package com.wulang.java.net.UdpServer;

import java.net.*;
import java.io.*;
public class UdpServer {
    private static final int PORT = 30000;
    // 每个数据报最大为4K
    private static final int DATA_LEN = 4096;
    // 接收网络数据的字节数组
    private byte[] buff_in = new byte[DATA_LEN];
    // 以指定字节数组创建准备接受数据的DatagramPacket对象
    private DatagramPacket packet_in = new DatagramPacket(buff_in, buff_in.length);

    private void start() throws IOException {
        try (
                // 创建DatagramSocket对象
                DatagramSocket socket = new DatagramSocket(PORT)) {
            // 采用循环接受数据
            while (true) {
                // 读取Socket中的数据，读到的数据放入inPacket封装的数组里。
                socket.receive(packet_in);
                // 判断inPacket.getData()和inBuff是否是同一个数组
                System.out.println(buff_in == packet_in.getData());
                // 将接收到的内容转成字符串后输出
                String _sIn = new String(buff_in, 0, packet_in.getLength());
                System.out.println("服务器端：" + _sIn);
                if ("shutdown".equals(_sIn)) {
                    break;
                }
                // 从字符串数组中取出一个元素作为发送的数据
                byte[] sendData = ("服务器收到:" + _sIn).getBytes();
                // 创建DatagramPacket作为回复
                SocketAddress addr = packet_in.getSocketAddress();
                // 定义一个用于发送的DatagramPacket对象
                DatagramPacket packet_out = new DatagramPacket(sendData, sendData.length, addr);
                // 发送数据
                socket.send(packet_out);
            }
            System.out.println("=====服务器关闭=====");
        }
    }
    public static void main(String[] args) throws IOException {
        new UdpServer().start();
    }
}
