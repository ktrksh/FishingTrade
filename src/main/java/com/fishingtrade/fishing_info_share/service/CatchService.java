package com.fishingtrade.fishing_info_share.service;

import com.fishingtrade.fishing_info_share.repository.CatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CatchService {

    @Autowired
    private CatchRepository catchRepository;

    // 釣果登録、一覧表示、オファー送信など、釣果に関するビジネスロジックを記述します。
}