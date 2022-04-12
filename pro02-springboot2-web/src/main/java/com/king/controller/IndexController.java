package com.king.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @author codeking
 * @date 2022/4/10 22:46
 */
@RestController
@RequestMapping("/save")
//类下面的方法都有的提取到上面
public class IndexController {
    // @RequestMapping("/myThymeleaf")
    // public String myThymeleaf(Map<String,Object> map){
    //     map.put("user",new UserEntity("CoderX",20));
    //     return "test";
    // }

    // @PostMapping("/post-request")
    // public Map<String, Object> postMethod(@RequestBody String content) {
    //     System.out.println("进来了！");
    //     Map<String, Object> map = new HashMap<>();
    //     map.put("content", content);
    //     return map;
    // }
    // @PostMapping 修改为@RequestMapping
    // @RequestMapping(method = RequestMethod.POST)
    // @RequestMapping("/save")
    // @RequestMapping(value ="/save",method = RequestMethod.POST)
    // @ResponseBody
    @PostMapping
    public Map postMethod(@RequestBody String content) {
        Map<String, Object> map = new HashMap<>();
        map.put("content", content);
        return map;
    }
}
