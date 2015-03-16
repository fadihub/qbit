/*
 * Copyright (c) 2015. Rick Hightower, Geoff Chandler
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *  		http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * QBit - The Microservice lib for Java : JSON, WebSocket, REST. Be The Web!
 */

package io.advantageous.qbit.vertx.http;

import io.advantageous.qbit.http.config.HttpServerOptions;
import io.advantageous.qbit.http.server.HttpServer;
import io.advantageous.qbit.queue.QueueBuilder;
import io.advantageous.qbit.spi.HttpServerFactory;
import io.advantageous.qbit.system.QBitSystemManager;
import io.advantageous.qbit.vertx.http.server.HttpServerVertx;

/**
 * @author rhightower on 1/26/15.
 */
public class HttpServerVertxFactory implements HttpServerFactory {


    @Override
    public HttpServer create(final HttpServerOptions options,
                             final QueueBuilder requestQueueBuilder,
                             final QueueBuilder responseQueueBuilder,
                             final QueueBuilder webSocketMessageQueueBuilder,
                             final QBitSystemManager systemManager) {


            return new HttpServerVertx(options, systemManager);

    }
}
