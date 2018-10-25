package com.Sockets;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Cliente {
    public static void main(String[] args) throws IOException, UnknownHostException {

        Socket cliente = new Socket("127.0.0.1", 12345);
        System.out.println("Você entrou no chat.");

        Scanner leitor = new Scanner(System.in);
        PrintStream saida = new PrintStream(cliente.getOutputStream());

        while (leitor.hasNextLine()) {
            saida.println(leitor.nextLine());
        }

        saida.close();
        leitor.close();
        cliente.close();

    }
}