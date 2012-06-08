/*
 * This file is part of websocktets-gl - simple WebSocket example
 * Copyright (C) 2012  Burt Parkers
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.github.bpark;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.ejb.EJB;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Spring controller to handle requests from the gui.
 *
 * Note: Two stateless session beans are used in two ways. One with @EJB injection, one with spring DI.
 * <p/>
 * <h3>Extra-Info</h3>
 * Created: 19:23 05.06.12
 *
 * @author Burt Parkers
 * @version 1.0
 */
@Controller
@RequestMapping(value="/blogposts")
public class BlogPostController {

    /**
     * The Dao to access the database. The SLSB is injected with EJB and with one of the jndi names:
     *
     * java:global/spring-ejb3-webapp/BlogPostDaoBean!com.github.bpark.BlogPostDaoBean
     * java:app/spring-ejb3-webapp/BlogPostDaoBean!com.github.bpark.BlogPostDaoBean
     * java:module/BlogPostDaoBean!com.github.bpark.BlogPostDaoBean
     * java:global/spring-ejb3-webapp/BlogPostDaoBean
     * java:app/spring-ejb3-webapp/BlogPostDaoBean
     * java:module/BlogPostDaoBean
     */
    @EJB(mappedName="java:app/spring-ejb3-webapp/BlogPostDaoBean")
    private BlogPostDaoBean blogPostDao;

    /** SLSB injected by spring, defined in servlet-context.xml. */
    @Autowired
    private SpamFilterService spamFilterService;


    /**
     * Returns the ModelAndView for creating a new posting.
     *
     * @return the ModelAndView.
     */
    @RequestMapping(value = "/new", method= RequestMethod.GET)
    public ModelAndView getCreateForm() {
        ModelAndView mav = new ModelAndView("new");
        mav.addObject(new BlogPost());
        return mav;
    }

    /**
     * Controller Method for processing a new Posting.
     *
     * @param blogPost the filled BlogPost.
     * @param result the BindingResult.
     * @return Redirection to home.
     * @throws SpamException if the new article is spam.
     */
    @RequestMapping(method=RequestMethod.POST)
    public String create(BlogPost blogPost, BindingResult result) throws SpamException {
        String content = blogPost.getContent();
        boolean isSpam = spamFilterService.checkSpam(content);
        if (isSpam) {
            throw new SpamException();
        }
        String shortContent;
        if (content.length() > 255) {
            shortContent = content.substring(0, 255);
        } else {
            shortContent = content;
        }
        blogPost.setShortContent(shortContent);
        blogPostDao.persist(blogPost);
        return "redirect:/blogposts/";
    }

    /**
     * Controller Method to list all articles.
     *
     * @return the ModelAndView.
     */
    @RequestMapping(value = "/", method= RequestMethod.GET)
    public ModelAndView getArticles() {
        ModelAndView mav = new ModelAndView("posts");
        List<BlogPost> blogPostList = blogPostDao.findAll();
        mav.addObject("articles", blogPostList);
        return mav;
    }

    /**
     * Controller Method to show one article.
     *
     * @param id the id value of the article.
     * @return the ModelAndView.
     */
    @RequestMapping(value="{id}", method=RequestMethod.GET)
    public ModelAndView getView(@PathVariable Integer id) {
        BlogPost blogPost = blogPostDao.find(id);
        if (blogPost == null) {
            throw new ResourceNotFoundException();
        }
        ModelAndView mav = new ModelAndView("article");
        mav.addObject("article", blogPost);
        return mav;
    }

    /**
     * Handles SpamExceptions.
     *
     * @param request the request.
     * @param response the response.
     * @param session the session.
     * @param e the SpamException.
     * @return the error page.
     */
    @ExceptionHandler(SpamException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ModelAndView handleSpamException(HttpServletRequest request, HttpServletResponse response,
                                            HttpSession session, SpamException e) {
        ModelMap model = new ModelMap();
        return new ModelAndView("/spam", model);
    }
}
