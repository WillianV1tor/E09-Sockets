package com.Sockets;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

    public static void main(String[] args) throws IOException {

        ServerSocket servidor = new ServerSocket(12345);
        System.out.println("Sala aberta.");

        for (int i = 0; i < 5; i++) {
            Socket cliente = servidor.accept();

            System.out.println(cliente.getInetAddress().getHostAddress() + "entrou.");

            MyRunnable myRunnableCliente = new MyRunnable(cliente);

            Thread thread = new Thread(myRunnableCliente);
            thread.start();
        }

        System.out.println("Sala fechada.");
        servidor.close();
    }
}
