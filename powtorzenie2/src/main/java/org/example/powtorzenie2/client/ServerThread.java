package org.example.powtorzenie2.client;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.function.Consumer;

public class ServerThread extends Thread{
//    Consumer<String> messageConsumer;
    private String  address;
    private String port;
    Socket socket;
    private PrintWriter out;

    public ServerThread(String address, String port) {
//        this.messageConsumer = messageConsumer;
        this.address = address;
        this.port = port;
        try {
            socket = new Socket(address, Integer.parseInt(port));
            out = new PrintWriter(socket.getOutputStream(), true);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void run() {
        // pass
    }

    public void send(String msg) {
        out.println(msg);
    }
}
