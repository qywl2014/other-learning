package com.wulang.spring.methodtest;

import com.wulang.spring.constant.BaseConstant;
import org.springframework.web.client.RestTemplate;

public class GetMelotConfigTest {
    public static void main(String[] args) {
        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject(BaseConstant.ABROAD_TEST_MESHOW,
                String.class, BaseConstant.GET_CONFIG);
        System.out.println(response);
    }
}
