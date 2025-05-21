package com.fishingtrade.fishing_info_share.controller;

import com.fishingtrade.fishing_info_share.entity.User;
import com.fishingtrade.fishing_info_share.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder; // PasswordEncoder を注入

    @GetMapping("/register")
    public String registerForm(Model model, @ModelAttribute("user") User user) { // @ModelAttribute を追加
        return "register";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute User user) {
        // パスワードをエンコード（ぐちゃぐちゃにする）
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        // UserService を使ってユーザー登録
        userService.register(user);
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String loginForm() {
        return "login";
    }
}