package com.fishingtrade.fishing_info_share.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "shared_catch_details")
public class SharedCatchDetails {

    @Id
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Id
    @ManyToOne
    @JoinColumn(name = "catch_id", nullable = false)
    private Catch catchDetails;

    // 主キーが複合キーのため、ゲッターのみ記述します。セッターは通常不要です。

    public User getUser() {
        return user;
    }

    public Catch getCatchDetails() {
        return catchDetails;
    }

    // 必要に応じて equals() と hashCode() メソッドをオーバーライドすることを推奨します。
    // 特に複合キーを持つエンティティでは重要です。
}