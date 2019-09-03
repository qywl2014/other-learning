package com.wulang.spring.methodtest;

import com.wulang.spring.constant.BaseConstant;
import org.springframework.web.client.RestTemplate;

public class FollowTest {
    public static void main(String[] args) {
        new Thread(new FollowTask()).start();
        new Thread(new FollowTask()).start();
        new Thread(new FollowTask()).start();
        new Thread(new FollowTask()).start();
    }

    public static class FollowTask implements Runnable {
        @Override
        public void run() {
            RestTemplate restTemplate = new RestTemplate();
            String response = restTemplate.getForObject(BaseConstant.ABROAD_TEST_MESHOW,
                    String.class, String.format(BaseConstant.FOLLOW,550491559,550492577,BaseConstant.TOKEN));
            System.out.println(response);
        }
    }
}
