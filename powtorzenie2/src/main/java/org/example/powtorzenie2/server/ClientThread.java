package org.example.powtorzenie2.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientThread extends Thread{
    private Socket socket;
    private Server server;
    private BufferedReader in;
    private PrintWriter out;

    public ClientThread(Socket socket, Server server) {
        this.socket = socket;
        this.server = server;

        try {
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);
        } catch (IOException e) {
            System.err.println("Błąd podczas inicjalizacji klienta: " + e.getMessage());
        }
    }

    @Override
    public void run() {
        try {
            String msg;
            while ((msg = in.readLine()) != null) {
                System.out.println("Otrzymano: " + msg);
                server.broadcast(msg, this);
            }
        } catch (IOException e) {
            System.err.println("Rozłączono klienta: " + e.getMessage());
        } finally {
//            server.removeClient(this);
//            close();
        }
    }

    public void send(String msg) {
        server.broadcast(msg, this);
    }
}
