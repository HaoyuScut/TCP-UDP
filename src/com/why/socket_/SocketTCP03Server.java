package com.why.socket_;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author 王浩宇
 * @version 1.0
 * @create 2023/03/22 16:45
 */
public class SocketTCP03Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9999);
        //服务器端开始监听....
        System.out.println("服务器端开始监听....");
        Socket socket = serverSocket.accept();
        System.out.println("成功与客户端建立连接");

        InputStream inputStream = socket.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String s = bufferedReader.readLine();
        System.out.println(s);

        OutputStream outputStream = socket.getOutputStream();
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
        bufferedWriter.write("hello, client!");
        bufferedWriter.newLine();
        bufferedWriter.flush();


        bufferedWriter.close();
        bufferedReader.close();
        socket.close();
        serverSocket.close();
    }
}
