package com.fishingtrade.fishing_info_share.service;

import com.fishingtrade.fishing_info_share.repository.ExchangeOfferRepository;
import com.fishingtrade.fishing_info_share.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExchangeOfferService {

    @Autowired
    private ExchangeOfferRepository exchangeOfferRepository;

    @Autowired
    private UserRepository userRepository;

    // 情報交換オファーの作成、承認、拒否など、オファーに関するビジネスロジックを記述します。
}