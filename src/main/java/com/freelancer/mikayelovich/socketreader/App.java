package com.freelancer.mikayelovich.socketreader;

import com.neovisionaries.ws.client.WebSocket;
import com.neovisionaries.ws.client.WebSocketAdapter;
import com.neovisionaries.ws.client.WebSocketExtension;
import com.neovisionaries.ws.client.WebSocketFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

/**
 * Hello world!
 */
public class App {
    private static final Logger log = LogManager.getLogger(App.class);

    private final static String WSS_URL = "wss://diffusion.oddschecker.com/diffusion?ty=WB&v=9&ca=8&r=600000";

    public static void main(String[] args) throws Exception {
// Connect to the echo server.
        WebSocket ws = connect();
        log.debug(ws);
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String firstMessage = "}?OC/market_3491519218/bet_.*/(OC|non_runner|bookmaker_(B3|SK|LD|WH|EE|FB|VC|PP|UN|CE|FR|WA|SA|BY|VT|OE|SO|BH|GN|SX|BF|BD|MK))";
        if (!s.equalsIgnoreCase("wait")) {
            ws.sendBinary(firstMessage.getBytes());
        }

    }
    private static WebSocket connect() throws Exception {

        WebSocketAdapter webSocketAdapter = new WebSocketAdapterImpl();

        WebSocket webSocket = new WebSocketFactory()
                .setConnectionTimeout(500000)
                .createSocket(WSS_URL)
                .addExtension(WebSocketExtension.PERMESSAGE_DEFLATE)
                .addListener(webSocketAdapter);
        webSocket.addHeader("Sec-WebSocket-Extensions", "permessage-deflate");
        webSocket.addHeader("Accept", "*/*");
        webSocket.addHeader("Accept-Encoding", "gzip, deflate, br");
        webSocket.addHeader("Accept-Language", "ru-RU,ru;q=0.8,en-US;q=0.5,en;q=0.3");
        return webSocket.connect();
    }
}
