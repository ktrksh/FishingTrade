package com.fishingtrade.fishing_info_share.entity;

import com.fishingtrade.fishing_info_share.entity.User;
import com.fishingtrade.fishing_info_share.entity.Catch;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class SharedCatchDetailsId implements Serializable {
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "catch_id")
    private Catch catchDetails;

    // デフォルトコンストラクタ

    public SharedCatchDetailsId() {
    }

    public SharedCatchDetailsId(User user, Catch catchDetails) {
        this.user = user;
        this.catchDetails = catchDetails;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Catch getCatchDetails() {
        return catchDetails;
    }

    public void setCatchDetails(Catch catchDetails) {
        this.catchDetails = catchDetails;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SharedCatchDetailsId that = (SharedCatchDetailsId) o;
        return Objects.equals(user, that.user) && Objects.equals(catchDetails, that.catchDetails);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user, catchDetails);
    }
}