package com.fishingtrade.fishing_info_share.service;

import com.fishingtrade.fishing_info_share.entity.User;
import com.fishingtrade.fishing_info_share.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void register(User user) {
        // パスワードのエンコード処理は UserController に移動します
        System.out.println("登録しようとしたユーザー: " + user.getUsername() + ", " + user.getEmail()); // 動作確認用
        userRepository.save(user);
    }
}