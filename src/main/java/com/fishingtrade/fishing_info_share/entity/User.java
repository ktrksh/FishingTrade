package com.fishingtrade.fishing_info_share.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table; // この行を追加



@Entity
@Table(name = "users") // この行を追加

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;
    private String password;

    // 必要に応じてゲッター、セッター、コンストラクタを追加
}