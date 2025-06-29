package org.example.powtorzenie2.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Server {
    private ServerSocket serverSocket;
    private List<ClientThread> clients = new CopyOnWriteArrayList<>(); // lista bezpieczna przy multi threadingu

    public Server(int port) throws IOException {
        try {
            System.out.println("Odpalam serwer");

            // Create a ServerSocket listening on given port
            this.serverSocket = new ServerSocket(port);
            System.out.println("Serwer nasłuchuje na porcie: " + port);

            new Thread(() -> {
                while (true) {
                    try {
                        // Accept a connection from a client
                        Socket clientSocket = serverSocket.accept();
                        ClientThread clientThread = new ClientThread(clientSocket, this);
                        clients.add(clientThread);
                        System.out.println("Klient połączony :D");

                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            }).start();
//            // Close the socket
//            serverSocket.close();
        } catch (Exception e) {
            System.out.println("Błąd Serwera: " + e);
        }
    }

    public void broadcast(String msg, ClientThread sender) {
        System.out.println(msg);
        for (ClientThread client : clients) {
            if (client != sender) {
                client.send(msg);
            }
        }
    }
}
