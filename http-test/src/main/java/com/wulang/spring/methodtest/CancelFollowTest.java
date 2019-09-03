package com.wulang.spring.methodtest;

import com.wulang.spring.constant.BaseConstant;
import org.springframework.web.client.RestTemplate;

public class CancelFollowTest {
    public static void main(String[] args) {
        new Thread(new CancelFollowTask()).start();
        new Thread(new CancelFollowTask()).start();
        new Thread(new CancelFollowTask()).start();
        new Thread(new CancelFollowTask()).start();
    }

    public static class CancelFollowTask implements Runnable {
        @Override
        public void run() {
            RestTemplate restTemplate = new RestTemplate();
            String response = restTemplate.getForObject(BaseConstant.ABROAD_TEST_MESHOW,
                    String.class, String.format(BaseConstant.CANCEL_FOLLOW,550491559,550492577,BaseConstant.TOKEN));
            System.out.println(response);
        }
    }
}
