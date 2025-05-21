package com.fishingtrade.fishing_info_share.service;

import com.fishingtrade.fishing_info_share.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // ユーザー登録、認証など、ユーザーに関するビジネスロジックを記述します。
}