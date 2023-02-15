package com.jordansamhi.utils;

/*-
 * #%L
 * Utils
 *
 * %%
 * Copyright (C) 2023 Jordan Samhi
 * All rights reserved
 *
 * %%
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation, either version 2.1 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Lesser Public License for more details.
 *
 * You should have received a copy of the GNU General Lesser Public
 * License along with this program.  If not, see
 * <http://www.gnu.org/licenses/lgpl-2.1.html>.
 * #L%
 */

public class TmpFolder {

    private static TmpFolder instance;

    public TmpFolder() {
    }

    public static TmpFolder v() {
        if (instance == null) {
            instance = new TmpFolder();
        }
        return instance;
    }

    /**
     * Gets the default temporary directory for the current system.
     *
     * @return the path to the default temporary directory for the current system
     */
    public String get() {
        return System.getProperty("java.io.tmpdir");
    }
}