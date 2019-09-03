package com.wulang.spring.methodtest;

import com.wulang.spring.constant.BaseConstant;
import com.wulang.spring.model.FanRank;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

public class GetForObjectLocalTest {
    public static void main(String[] args) {
        SimpleClientHttpRequestFactory simpleClientHttpRequestFactory = new SimpleClientHttpRequestFactory();
        simpleClientHttpRequestFactory.setReadTimeout(5000);
        RestTemplate restTemplate = new RestTemplate(simpleClientHttpRequestFactory);
        FanRank response = restTemplate.getForObject(BaseConstant.GET_FAN_RANK_URL, FanRank.class);
        System.out.println(response);
    }
}
