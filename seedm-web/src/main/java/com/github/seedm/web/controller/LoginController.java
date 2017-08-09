package com.github.seedm.web.controller;

import com.github.seedm.entities.result.FlagResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 登录相关处理控制器
 * @author Eugene
 */
@Controller
@RequestMapping("/login")
public class LoginController {

    @RequestMapping(value = "/submit")
    public String submit() {
        FlagResult flagResult = new FlagResult();
        return "";
    }
}
