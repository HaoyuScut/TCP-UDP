package com.why.socket_;



import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author 王浩宇
 * @version 1.0
 * @create 2023/03/22 16:30
 *
 */
public class SocketTCP01Server {
    public static void main(String[] args) throws IOException {
        //要求在本机没有其他服务在监听9999
        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("服务端在9999端监听，等待连接");
        //当没有客户端连接9999，程序会阻塞等待连接
        //如果有，会返回一个Socket对象
        Socket socket = serverSocket.accept();
        System.out.println("服务器端 socket = " + socket.getClass());
        InputStream inputStream = socket.getInputStream();
        //IO读取
        byte[] buf = new byte[1024];
        int readLen = 0;
        while ((readLen = inputStream.read(buf)) != -1){
            System.out.println(new String(buf, 0, readLen));
        }
        inputStream.close();
        socket.close();
        serverSocket.close();

    }
}
