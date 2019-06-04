package com.wulang.apache;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Scanner;

public class GetTest{
    public static String uri;
    static{
        try {
            uri="http://10.0.3.173:9090/meShow/entrance?parameter="+URLEncoder.encode("{\"FuncTag\":51011005,\"userId\":550492577}","utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {
        // 创建一个 HttpClient 对象
        CloseableHttpClient httpclient = HttpClients.createDefault();

        // 创建一个 HttpGet 对象
        HttpGet httpget = new HttpGet(uri);

        //Executing the Get request
        HttpResponse httpresponse = httpclient.execute(httpget);

//        HttpEntity httpEntity =httpresponse.getEntity();
//        String response=EntityUtils.toString(httpEntity,"utf-8");
//        System.out.println(response);

        Scanner sc = new Scanner(httpresponse.getEntity().getContent());
        System.out.println(httpresponse.getStatusLine());
        while(sc.hasNext()){
            System.out.println(sc.nextLine());
        }
    }
}
