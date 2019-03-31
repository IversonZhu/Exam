package com.exam.controller;

import com.alibaba.fastjson.JSONObject;
import com.exam.entity.User;
import com.exam.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/index")
public class UserController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    @Qualifier("userService")
    private UserService userService;

    @RequestMapping(value = "/testController1", method = RequestMethod.GET)
    @ResponseBody
    public JSONObject indexTest() {
        int i = userService.testContoller();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("test",i);
        return jsonObject;
    }

    @RequestMapping(value = "/testController2", method = RequestMethod.GET)
    public String indexTest2() {
        return "home";
    }

    @RequestMapping("/query")
    public String query(@RequestParam(value = "username",required = true) String username, Model model) {
        User user = new User();
        user = userService.queryByUserName(username);
        model.addAttribute("user",user);
        return "test";
    }
}
