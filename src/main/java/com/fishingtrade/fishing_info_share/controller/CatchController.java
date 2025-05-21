package com.fishingtrade.fishing_info_share.controller;

import com.fishingtrade.fishing_info_share.service.CatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/catches")
public class CatchController {

    @Autowired
    private CatchService catchService;

    @GetMapping("/register")
    public String registerForm() {
        return "catch_register"; // templates/catch_register.html を表示する想定
    }

    @PostMapping("/register")
    public String register() {
        // 釣果登録処理を記述します。
        return "redirect:/mypage"; // 登録後マイページへリダイレクトする想定
    }

    @GetMapping("/list")
    public String list() {
        // 公開釣果一覧表示処理を記述します。
        return "catch_list"; // templates/catch_list.html を表示する想定
    }
}