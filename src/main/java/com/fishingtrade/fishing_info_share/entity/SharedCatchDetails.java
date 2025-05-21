package com.fishingtrade.fishing_info_share.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "shared_catch_details")
public class SharedCatchDetails {

    @Id
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((user == null) ? 0 : user.hashCode());
        result = prime * result + ((catchDetails == null) ? 0 : catchDetails.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        SharedCatchDetails other = (SharedCatchDetails) obj;
        if (user == null) {
            if (other.user != null)
                return false;
        } else if (!user.equals(other.user))
            return false;
        if (catchDetails == null) {
            if (other.catchDetails != null)
                return false;
        } else if (!catchDetails.equals(other.catchDetails))
            return false;
        return true;
    }

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