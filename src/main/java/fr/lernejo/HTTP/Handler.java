package fr.lernejo.HTTP;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

public class Handler implements HttpHandler {
    @Override
    public void handle(HttpExchange exchange) throws IOException {
        exchange.sendResponseHeaders(HttpURLConnection.HTTP_OK, 2);
        OutputStreamWriter writer = new OutputStreamWriter(exchange.getResponseBody());
        writer.append("OK");
        writer.close();
        exchange.close();
    }
}
