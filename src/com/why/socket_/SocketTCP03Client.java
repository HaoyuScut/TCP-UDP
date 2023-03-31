package com.why.socket_;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @author 王浩宇
 * @version 1.0
 * @create 2023/03/22 16:45
 */
public class SocketTCP03Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);
        System.out.println("成功与客户端建立连接");
        System.out.println("客户端socket" + socket.getClass());

        OutputStream outputStream = socket.getOutputStream();
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
        bufferedWriter.write("hello, client!");
        bufferedWriter.newLine();
        bufferedWriter.flush();

        InputStream inputStream = socket.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String s = bufferedReader.readLine();
        System.out.println(s);

        bufferedWriter.close();
        bufferedReader.close();
        socket.close();
    }
}
