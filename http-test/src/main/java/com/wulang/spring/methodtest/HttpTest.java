package com.wulang.spring.methodtest;

import com.google.gson.Gson;
import com.wulang.spring.constant.BaseConstant;
import com.wulang.spring.model.FanRank;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class HttpTest {
    public static void main(String[] args) {
        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject(BaseConstant.ABROAD_TEST_MESHOW, String.class, BaseConstant.FAN_RANK);
        System.out.println(new Gson().fromJson(response, FanRank.class));
//        ResponseEntity r=restTemplate.getForEntity();
//        HttpHeaders headers =r.getHeaders();
//        HttpHeaders
    }
}
