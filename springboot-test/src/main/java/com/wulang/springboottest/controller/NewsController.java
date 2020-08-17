package com.wulang.springboottest.controller;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NewsController {
    private static int count = 0;

    @GetMapping("/api/skNewsTopic")
    public String a(String dt, int type) {
//        count++;
//        if (count % 2 == 0) {
//            return null;
//        }
        JsonObject jsonObject = new JsonObject();
        if (type == 1) {
            jsonObject.addProperty("code", 200);
            jsonObject.addProperty("msg", "ok");

            JsonArray jsonArray = new JsonArray();
            JsonObject news = new JsonObject();
            news.addProperty("dynamicId", 22864);
            news.addProperty("cnt", 10);
            jsonArray.add(news);
            JsonObject news1 = new JsonObject();
            news1.addProperty("dynamicId", 23073);
            news1.addProperty("cnt", 20);
            jsonArray.add(news1);
            jsonObject.add("data", jsonArray);
        } else if (type == 2) {
            jsonObject.addProperty("code", 200);
            jsonObject.addProperty("msg", "ok");

            JsonArray jsonArray = new JsonArray();
            JsonObject topic = new JsonObject();
            topic.addProperty("topicId", 20508);
            topic.addProperty("num", 10);
            topic.addProperty("cnt", 20);
            jsonArray.add(topic);
            JsonObject topic1 = new JsonObject();
            topic1.addProperty("topicId", 20509);
            topic1.addProperty("num", 20);
            topic1.addProperty("cnt", 40);
            jsonArray.add(topic1);
            jsonObject.add("data", jsonArray);
        }


        return jsonObject.toString();
    }
}
