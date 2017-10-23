package com.github.seedm.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 主要页面导航跳转控制器
 * @author Eugene
 */
@Controller
@RequestMapping("/main")
public class MainController {

    private final Logger logger = LoggerFactory.getLogger(MainController.class);

    /**
     * 跳转到登录页面
     * @return 登录页面地址
     */
    @RequestMapping(value = "/login")
    public String login() {
        this.logger.info("Login Method!");
        return "/main/login";
    }

    /**
     * 跳转到管理系统主页面
     * @return 管理系统主页面
     */
    @RequestMapping(value = "/index")
    public String index() {
        return "/main/index";
    }

    /**
     * 跳转到管理系统默认主页面
     * @return 管理系统默认主页面
     */
    @RequestMapping(value = "/default")
    public String defaultPage() {
        return "/main/default";
    }
}
