package com.wulang.javanet;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class GetTest {
    public static void main(String[] args) throws Exception {
        URL url = new URL(com.wulang.apache.GetTest.uri);
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setRequestMethod("GET");
        httpURLConnection.setConnectTimeout(10000);
        httpURLConnection.setReadTimeout(5000);
        httpURLConnection.setDoInput(true);

//        InputStream errorIn=httpURLConnection.getErrorStream();
        InputStream in = httpURLConnection.getInputStream();
//        httpURLConnection.setDoInput(true);
        BufferedReader rd = new BufferedReader(new InputStreamReader(in, "UTF-8"));
        StringBuilder sB = new StringBuilder();
        String tempLine = null;
        while ((tempLine = rd.readLine()) != null) {
            sB.append(tempLine);
        }
        System.out.println(sB);
        rd.close();
    }
}
