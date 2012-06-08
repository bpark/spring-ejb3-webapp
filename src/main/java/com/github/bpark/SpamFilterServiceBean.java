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

/**
 * Simplest implementation to detect spam.
 *
 * Note: This implementation is primarily used to demonstrate ejb dependency injection, not to do a useful spam detection.
 * <p/>
 * <h3>Extra-Info</h3>
 * Created: 11:26 08.06.12
 *
 * @author Burt Parkers
 * @version 1.0
 */
@Stateless
public class SpamFilterServiceBean implements SpamFilterService {

    /** Spam word list. */
    private static final String[] SPAM_WORDS = {"http", "sex", "porn", "buy"};

    @Override
    public boolean checkSpam(String content) {
        for (String spamWord : SPAM_WORDS) {
            if (content.contains(spamWord)) {
                return true;
            }
        }
        return false;
    }
}
