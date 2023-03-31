package com.why;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author 王浩宇
 * @version 1.0
 * @create 2023/03/22 16:04
 * 演示INetAddress 类使用
 */
public class API_ {

    public static void main(String[] args) throws UnknownHostException {
        //获取本机的InetAddress对象
        InetAddress localHost = InetAddress.getLocalHost();
        System.out.println(localHost);//218.192.172.44

        //2.根据指定的主机名 获取 InetAddress对象
        InetAddress host1 = InetAddress.getByName("DESKTOP-8UASEJA");
        System.out.println("host1 = " + host1);

        //3.根据域名返回InetAddress对象
        InetAddress host2 = InetAddress.getByName("www.baidu.com");
        System.out.println("host2 = " + host2);//182.61.200.6

        //4.通过InetAddress对象获取对应的地址和主机名
        String hostName = host2.getHostName();
        String hostAddress = host2.getHostAddress();
        System.out.println(hostName + "  " + hostAddress);
    }

}
