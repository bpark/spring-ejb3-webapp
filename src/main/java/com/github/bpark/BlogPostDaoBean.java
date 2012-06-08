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

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

/**
 * Dao Bean to access the database.
 * <p/>
 * <h3>Extra-Info</h3>
 * Created: 17:50 07.06.12
 *
 * @author Burt Parkers
 * @version 1.0
 */
@Stateless
public class BlogPostDaoBean {

    /** The EntityManager. */
    @PersistenceContext(unitName = "blogpost-persistence")
    private EntityManager entityManager;

    /**
     * Persits a new BlogPost entity.
     *
     * @param blogPost the entity to persist.
     */
    public void persist(BlogPost blogPost) {
        entityManager.persist(blogPost);
    }

    /**
     * Returns all entities.
     *
     * @return list with all entities.
     */
    @SuppressWarnings("unchecked")
    public List<BlogPost> findAll() {
        CriteriaQuery criteriaQuery = entityManager.getCriteriaBuilder().createQuery();
        criteriaQuery.select(criteriaQuery.from(BlogPost.class));
        return entityManager.createQuery(criteriaQuery).getResultList();
    }

    /**
     * Finds a specific entity by id.
     *
     * @param id the id.
     * @return the found entity or null if the entity can't be found.
     */
    public BlogPost find(int id) {
        try {
            return entityManager.find(BlogPost.class, id);
        } catch (NoResultException e) {
            return null;
        }
    }
}
