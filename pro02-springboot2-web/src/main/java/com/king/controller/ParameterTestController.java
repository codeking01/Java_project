package com.king.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author codeking
 * @date 2022/4/10 22:11
 */
@RestController
public class ParameterTestController {

    // @PostMapping("/post-request")
    // public Map<String, Object> postMethod(@RequestBody(required = true) String content) {
    //     Map<String, Object> map = new HashMap<>();
    //     map.put("content", content);
    //     return map;
    // }
}
