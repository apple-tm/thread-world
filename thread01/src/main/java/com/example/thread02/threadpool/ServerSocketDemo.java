package com.example.thread02.threadpool;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSocketDemo {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9999);
        while (true) {
            // accept 方法是一个阻塞方法
            final Socket connection = serverSocket.accept();
            Runnable task = () -> handleRequest(connection);
            new Thread(task).start();
        }
    }

    public static void handleRequest(Socket connection) {
        System.out.println(Thread.currentThread().getName());
        System.out.println(connection);
    }
}
