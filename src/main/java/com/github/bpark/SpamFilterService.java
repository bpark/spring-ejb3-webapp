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

import javax.ejb.Local;

/**
 * Local interface for the SpamFilterService SLSB. The interface is required by spring ejb DI.
 * <p/>
 * <h3>Extra-Info</h3>
 * Created: 11:37 08.06.12
 *
 * @author Burt Parkers
 * @version 1.0
 */
@Local
public interface SpamFilterService {

    /**
     * Checks a text for spam words.
     *
     * @param content the content to check.
     * @return true if the text contains spam or inadequate words, otherwise false.
     */
    boolean checkSpam(String content);
}
