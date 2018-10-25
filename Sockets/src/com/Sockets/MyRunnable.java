package com.Sockets;

import javax.imageio.IIOException;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class MyRunnable implements java.lang.Runnable {

    private Socket cliente;

    MyRunnable (Socket cliente) {
        this.cliente = cliente;
    }

    @Override
    public void run() {
        try{
            Scanner leitor = new Scanner(cliente.getInputStream());

            while (leitor.hasNextLine()) {
                System.out.println(cliente.getInetAddress().getHostAddress() + " disse: " + leitor.nextLine());
            }

            leitor.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            System.out.println("Você saiu.");
        }
    }
}
