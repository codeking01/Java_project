package com.king.boot.controller;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

import static sun.net.www.protocol.http.HttpURLConnection.userAgent;

/**
 * @author codeking
 * @date 2022/4/10 15:08
 */
@RestController
public class ParameterTestController {
    // car/2/owner/zhangsan
    @GetMapping("/car/{id}/owner/{username}")
    public Map<String, Object> getCar(@PathVariable("id") Integer id,
                                      @PathVariable("username") String name,
                                      @PathVariable Map<String, String> pv,
                                      @RequestHeader Map<String,String> header
    ) {
        Map<String, Object> map = new HashMap<>();
        map.put("id", id);
        map.put("name", name);
        map.put("pv", pv);
        map.put("userAgent",userAgent);
        map.put("headers",header);
        return map;
    }

    @PostMapping("/save")
    public Map<String, String> postMethod(@RequestBody(required = false) String content) {
        System.out.println("进来了！");
        Map<String, String> map = new HashMap<>();
        map.put("content", content);
        return map;
    }
}