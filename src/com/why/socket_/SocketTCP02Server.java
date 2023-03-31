package com.why.socket_;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author 王浩宇
 * @version 1.0
 * @create 2023/03/22 16:45
 */
public class SocketTCP02Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9999);
        //服务器端开始监听....
        System.out.println("服务器端开始监听....");
        Socket socket = serverSocket.accept();
        System.out.println("成功与客户端建立连接");
        InputStream inputStream = socket.getInputStream();
        byte[] buf = new byte[1024];
        int readLen = 0;
        while((readLen = inputStream.read(buf)) != -1) {
            System.out.println(new String(buf, 0, readLen));
        }
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("hello, client!".getBytes());
        socket.shutdownOutput();

        outputStream.close();
        inputStream.close();
        socket.close();
        serverSocket.close();
    }
}
