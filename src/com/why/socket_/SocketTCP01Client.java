package com.why.socket_;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * @author 王浩宇
 * @version 1.0
 * @create 2023/03/22 16:34
 * 客户端发送hello sever给服务端
 */
public class SocketTCP01Client {
    public static void main(String[] args) throws IOException {
        //1.链接服务器端（ip,端口）
        //连接本机的9999端口
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);
        System.out.println("客户端socket = " + socket.getClass());
        //2.如果连接成功，返回socket对象
        //得到和socket对象关联的输出流对象
        OutputStream outputStream = socket.getOutputStream();
        //通过输出流写数据到数据通道
        outputStream.write("hello,server".getBytes());

        //关闭流对象和socket
        outputStream.close();
        socket.close();
        System.out.println("客户端退出...");
    }
}
