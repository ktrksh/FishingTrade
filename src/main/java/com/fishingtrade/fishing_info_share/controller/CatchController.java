package com.fishingtrade.fishing_info_share.controller;

import com.fishingtrade.fishing_info_share.entity.Catch;
import com.fishingtrade.fishing_info_share.service.CatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/catches")
public class CatchController {

    @Autowired
    private CatchService catchService;

    @GetMapping("/register")
    public String registerForm(Model model, @ModelAttribute("catch") Catch catchForm) { // パラメータ名を catch から catchForm
                                                                                        // に変更
        return "catch_register";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute Catch catchData) {
        // 釣果登録処理を記述します。
        System.out.println("登録しようとした釣果: " + catchData.getSpecies() + ", " + catchData.getCount()); // 動作確認用
        return "redirect:/mypage";
    }

    @GetMapping("/list")
    public String list() {
        // 公開釣果一覧表示処理を記述します。
        return "catch_list";
    }
}