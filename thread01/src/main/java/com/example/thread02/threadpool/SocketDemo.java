package com.example.thread02.threadpool;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketDemo {

    public static void main(String [] args) throws IOException {
        Socket client = new Socket("127.0.0.1", 9999);
        client.close();
    }
}
