package com.jordansamhi.utils.network;

import redis.clients.jedis.Jedis;

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

/**
 * RedisManager is a utility class for sending values to a Redis server. It connects to a specified Redis server using the
 * given connection parameters, and can send a value to a specified list in the server.
 */
public class RedisManager {

    private final Jedis jedis;

    /**
     * Constructs a new RedisManager object and connects to the specified Redis server using the given connection parameters.
     *
     * @param server the server name or IP address of the Redis server
     * @param port   the port number on which the Redis server is listening
     * @param auth   the authentication password for the Redis server (may be null if authentication is not required)
     */
    public RedisManager(String server, String port, String auth) {
        this.jedis = new Jedis(String.format("redis://%s:%s", server, port));
        this.jedis.auth(auth);
        this.jedis.connect();
    }

    /**
     * Sends a value to a Redis list using the connection established by this RedisManager.
     *
     * @param list the name of the Redis list to which to send the value
     * @param val  the value to send to the Redis list
     */
    public void lpush(String list, String val) {
        this.jedis.select(0);
        this.jedis.lpush(list, val);
    }

    /**
     * Removes and returns a random member from a Redis set using the connection established by this RedisManager.
     *
     * @param set the name of the Redis set from which to remove and return a random member
     * @return the randomly removed member from the Redis set
     */
    public String spop(String set) {
        return this.jedis.spop(set);
    }
}
