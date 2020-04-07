package com.freelancer.mikayelovich.socketreader;

import com.neovisionaries.ws.client.WebSocket;
import com.neovisionaries.ws.client.WebSocketAdapter;
import com.neovisionaries.ws.client.WebSocketFrame;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class WebSocketAdapterImpl extends WebSocketAdapter {
    private static final Logger log = LogManager.getLogger(App.class);

    @Override
    public void onFrame(WebSocket websocket, WebSocketFrame frame) throws Exception {
        log.debug(frame);
    }

    @Override
    public void onSendingFrame(WebSocket websocket, WebSocketFrame frame) throws Exception {
        log.debug(frame);
    }

    @Override
    public void onBinaryFrame(WebSocket websocket, WebSocketFrame frame) throws Exception {
    }

    @Override
    public void onTextMessage(WebSocket websocket, String text) throws Exception {
    }


    @Override
    public void onTextMessage(WebSocket websocket, byte[] data) throws Exception {
        String charsetName = Helper.guessEncoding(data);
        String strData = new String(data, charsetName);
        log.debug(strData);
    }

    public void onBinaryMessage(WebSocket websocket, byte[] data) throws Exception {
        log.debug(new String(data, Helper.guessEncoding(data)));
        System.out.println(new String(data, Helper.guessEncoding(data)));
    }

    public void onTextFrame(WebSocket websocket, WebSocketFrame frame) throws Exception {
        log.debug(frame);
    }
}
