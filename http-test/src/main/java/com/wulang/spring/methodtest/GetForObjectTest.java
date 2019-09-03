package com.wulang.spring.methodtest;

import com.wulang.spring.constant.BaseConstant;
import com.wulang.spring.model.FanRank;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

public class GetForObjectTest {
    public static void main(String[] args) {
        RestTemplate restTemplate = new RestTemplate();
        makeJsonConverterSupportAllType(restTemplate);
        FanRank response = restTemplate.getForObject(BaseConstant.ABROAD_TEST_MESHOW, FanRank.class, BaseConstant.FAN_RANK);
        System.out.println(response);
    }

    public static void makeJsonConverterSupportAllType(RestTemplate restTemplate) {
        for (HttpMessageConverter httpMessageConverter : restTemplate.getMessageConverters()) {
            if (httpMessageConverter instanceof MappingJackson2HttpMessageConverter) {
                ((MappingJackson2HttpMessageConverter) httpMessageConverter).setSupportedMediaTypes(Collections.singletonList(new MediaType("*")));
            }
        }

    }
}
