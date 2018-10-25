package com.Sockets;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Servidor {

    public static void main(String[] args) throws IOException {

        ServerSocket servidor = new ServerSocket(12345);
        System.out.println("Sala aberta.");

        Socket cliente = servidor.accept();

        System.out.println("Nova conexão com o cliente: " + cliente.getInetAddress().getHostAddress());

        Scanner leitor = new Scanner(cliente.getInputStream());

        while (leitor.hasNextLine()) {
            System.out.println(cliente.getInetAddress().getHostAddress() + " disse: " + leitor.nextLine());
        }

        System.out.println("Sala fechada.");

        leitor.close();
        cliente.close();
        servidor.close();
    }
}
