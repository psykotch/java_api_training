package fr.lernejo.navy_battle;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import fr.lernejo.HTTP.Handler;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Launcher {

    public static HttpServer createServer(InetSocketAddress addr, int backlog) {
        HttpServer s = null;
        try {
            s = HttpServer.create(addr, backlog);
        } catch (IOException e) {
            System.err.println("Could not create server ! Cause : " + e.getLocalizedMessage());
            e.printStackTrace();
            return null;
        }
        ExecutorService service = Executors.newFixedThreadPool(1);
        s.setExecutor(service);
        s.createContext("/ping", new Handler());
        s.start();
        return s;
    }
    public static void main(String[] args) {
    }
}
