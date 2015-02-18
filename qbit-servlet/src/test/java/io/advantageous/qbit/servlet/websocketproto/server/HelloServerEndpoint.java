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

package io.advantageous.qbit.servlet.websocketproto.server;

import io.advantageous.qbit.servlet.websocketproto.model.Hello;
import io.advantageous.qbit.servlet.websocketproto.protocol.HelloDecoder;
import io.advantageous.qbit.servlet.websocketproto.protocol.HelloEncoder;

import javax.websocket.*;
import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;


/**
 * @author rhightower on 2/12/15.
 */
@javax.websocket.server.ServerEndpoint(
        value = "/hello",
        encoders = {HelloEncoder.class},
        decoders = {HelloDecoder.class}
)
public class HelloServerEndpoint {
    private static final Set<Session> sessions = Collections.synchronizedSet(new HashSet<>());

    @OnOpen
    public void onOpen(final Session session) {
        sessions.add(session);
    }

    @OnClose
    public void onClose(final Session session) {
        sessions.remove(session);
    }

    @OnMessage
    public void onMessage(final Hello hello, final Session client) throws IOException, EncodeException {
        for (final Session session : sessions) {
            session.getBasicRemote().sendObject(new Hello("RESPONSE FROM SERVER " + hello.getHello()));
        }
    }
}
