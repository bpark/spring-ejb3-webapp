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

/**
 * Entity class for blog posts.
 *
 * Note not all fields are used for this example application. The field shortcontent is used to prevent loading the full
 * article content by findAll() Methods.
 * <p/>
 * <h3>Extra-Info</h3>
 * Created: 19:13 05.06.12
 *
 * @author Burt Parkers
 * @version 1.0
 */

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class BlogPost {

    /** The id value. */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    /** The author, unused. */
    private String author;

    /** The title. */
    private String title;

    /** Short content of the article. */
    private String shortContent;

    /** The article content. */
    @Lob
    @Basic(fetch = FetchType.LAZY)
    private String content;


    /**
     * Gets the id value.
     *
     * @return the id value.
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the id value.
     *
     * @param id the id value.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets the author.
     *
     * @return the author.
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Sets the author.
     *
     * @param author the author.
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * Gets the content.
     *
     * @return the content.
     */
    public String getContent() {
        return content;
    }

    /**
     * Sets the content.
     *
     * @param content the content.
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * Gets the title.
     *
     * @return the title.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the title.
     *
     * @param title the title.
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Gets the short content.
     *
     * @return the short content.
     */
    public String getShortContent() {
        return shortContent;
    }

    /**
     * Sets the short content.
     *
     * @param shortContent the short content.
     */
    public void setShortContent(String shortContent) {
        this.shortContent = shortContent;
    }
}
