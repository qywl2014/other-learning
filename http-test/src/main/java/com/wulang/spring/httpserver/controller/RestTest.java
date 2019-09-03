package com.wulang.spring.httpserver.controller;

import com.wulang.spring.model.FanRank;
import com.wulang.spring.model.FanRankItem;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class RestTest {

    @RequestMapping("getFanRank")
    public FanRank getFanRank(){
        FanRank fanRank=new FanRank();
        fanRank.setTagCode("123");
        fanRank.setTotalCount(100);
        fanRank.setFansList(new ArrayList<FanRankItem>());
        return fanRank;
    }
}
