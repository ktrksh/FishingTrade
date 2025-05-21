package com.fishingtrade.fishing_info_share.controller;

import com.fishingtrade.fishing_info_share.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/register")
    public String registerForm() {
        return "register"; // templates/register.html を表示する想定
    }

    @PostMapping("/register")
    public String register() {
        // ユーザー登録処理を記述します。
        return "redirect:/login"; // 登録後ログイン画面へリダイレクトする想定
    }

    @GetMapping("/login")
    public String loginForm() {
        return "login"; // templates/login.html を表示する想定
    }

    @PostMapping("/login")
    public String login() {
        // ログイン処理を記述します。
        return "redirect:/mypage"; // ログイン後マイページへリダイレクトする想定
    }
}