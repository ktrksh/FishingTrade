package com.fishingtrade.fishing_info_share.controller;

import com.fishingtrade.fishing_info_share.service.ExchangeOfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/offers")
public class OfferController {

    @Autowired
    private ExchangeOfferService exchangeOfferService;

    @PostMapping("/send/{catchId}")
    public String sendOffer(@PathVariable Long catchId) {
        // 情報交換オファー送信処理を記述します。
        return "redirect:/catches/list"; // オファー送信後釣果一覧へリダイレクトする想定
    }

    @GetMapping("/received")
    public String receivedOffers() {
        // 受信したオファー一覧表示処理を記述します。
        return "offer_received"; // templates/offer_received.html を表示する想定
    }

    @PostMapping("/approve/{offerId}")
    public String approveOffer(@PathVariable Long offerId) {
        // オファー承認処理を記述します。
        return "redirect:/offers/received"; // 承認後受信オファー一覧へリダイレクトする想定
    }

    @PostMapping("/reject/{offerId}")
    public String rejectOffer(@PathVariable Long offerId) {
        // オファー拒否処理を記述します。
        return "redirect:/offers/received"; // 拒否後受信オファー一覧へリダイレクトする想定
    }
}