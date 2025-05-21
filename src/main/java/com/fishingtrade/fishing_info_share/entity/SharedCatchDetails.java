package com.fishingtrade.fishing_info_share.entity;

import java.util.Objects;
import jakarta.persistence.*;

@Entity
@Table(name = "shared_catch_details")
public class SharedCatchDetails {

    @EmbeddedId
    private SharedCatchDetailsId id;

    public SharedCatchDetailsId getId() {
        return id;
    }

    public void setId(SharedCatchDetailsId id) {
        this.id = id;
    }

    // 必要に応じてコンストラクタ、ゲッター、セッターを追加

    public User getUser() {
        return this.id.getUser();
    }

    public Catch getCatchDetails() {
        return this.id.getCatchDetails();
    }

    public SharedCatchDetails() {
        this.id = new SharedCatchDetailsId();
    }

    public SharedCatchDetails(User user, Catch catchDetails) {
        this.id = new SharedCatchDetailsId(user, catchDetails);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SharedCatchDetails that = (SharedCatchDetails) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}