package com.spring.boot.controller;

import com.spring.boot.service.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


/**
 * Controller层
 *
 * @author 代码的路
 * @date 2022/6/8
 */


@RestController
@RequestMapping("/homepage")
public class MyController {

    @Autowired
    MyService myService;

    @GetMapping("/learnGet")
    public String learnGet(){
        return myService.learnGet();
    }

    @PostMapping("/postReceive")
    public Map<String, Object> postReceive(@RequestParam("number") int number, @RequestParam("name") String name) {
        return myService.postReceive(number, name);
    }

    @PostMapping("/postReceiveByMap")
    public Map<String, Object> postReceiveByMap(@RequestParam Map<String, Object> map) {
        return myService.postReceiveByMap(map);
    }
}
