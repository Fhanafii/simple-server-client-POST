package com.fhanafi.simpleserver;

import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) throws Exception {
        //inisialisasi server socket
        ServerSocket ss = new ServerSocket(1234);
        System.out.println("Server Started. listening on port 1234...");
        //open socket
        while (true) {
            Socket s = ss.accept();
            System.out.println("Client connected: 127.0.0.1");
            DataInputStream input = new DataInputStream(s.getInputStream());
            try {
                // Server membaca pesan ke client dengan looping
                while (true) {
                    String pesan = input.readLine();
                    if (pesan == null) {
                        System.out.println("Client disconnected");
                        break;
                    }
                    System.out.println("Pesan dari client :\ntotal harga : " + pesan);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
