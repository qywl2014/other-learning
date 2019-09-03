package com.wulang.javanet;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Optional;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SocketHttpServer {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(90);
        while(true){
            final Socket socket = serverSocket.accept();
            System.out.println("accept-----"+socket);
            ExecutorService executorService = Executors.newFixedThreadPool(10);
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        InputStream inputStream = socket.getInputStream();
//                        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream));
//                        String str;
//                        while((str=bufferedReader.readLine())!=null){
//                            System.out.println(str);
//                        }
//                        bufferedReader.close();

//                        Scanner scanner=new Scanner(inputStream);
//                        while (scanner.hasNext()){
//                            System.out.println(scanner.nextLine());
//                        }
//                        scanner.close();
                        byte[] bytes=new byte[20480];
                        inputStream.read(bytes);
                        System.out.println(new String(bytes));
                        inputStream.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }
            });
        }
    }
}
