package com.spring.boot.service;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;


/**
 * Service层
 *
 * @author 代码的路
 * @date 2022/6/8
 */

@Service
@EnableScheduling
public class MyService {

    public String learnGet(){

        Long timeLong = System.currentTimeMillis();
        SimpleDateFormat timeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); //设置格式
        String timeString = timeFormat.format(timeLong);

        return timeString;
    }

    public Map<String, Object> postReceive(int number, String name){
        Map<String, Object> res = new HashMap<>();
        res.put("number", number);
        res.put("name", name);

        return res;
    }

    public Map<String, Object> postReceiveByMap(Map<String, Object> map){
        int number = map.get("number") == null ? 0 : Integer.parseInt((String) map.get("number"));
        String name = map.get("name") == null ? "" : (String)map.get("name");

        Map<String, Object> res = new HashMap<>();
        res.put("number", number);
        res.put("name", name);

        System.out.println("map:" + map + "\n");
        System.out.println("res:" + res + "\n");
        return res;
    }


    @Scheduled(cron = "1/10 * * * * ? ")  //10s一次
    public void learnCron(){

        Long timeLong = System.currentTimeMillis();
        SimpleDateFormat timeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); //设置格式
        String timeString = timeFormat.format(timeLong);
//        System.out.println("timeString:" + timeString + "\n");
    }
}
