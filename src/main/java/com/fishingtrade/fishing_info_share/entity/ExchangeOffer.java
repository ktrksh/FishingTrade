package com.fishingtrade.fishing_info_share.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "exchange_offers")
public class ExchangeOffer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "offering_user_id", nullable = false)
    private User offeringUser;

    @ManyToOne
    @JoinColumn(name = "requested_catch_id", nullable = false)
    private Catch requestedCatch;

    @Column(nullable = false, length = 20, columnDefinition = "VARCHAR(20) DEFAULT 'pending'")
    private String status;

    // 必要に応じてゲッター、セッター、コンストラクタを追加してください。
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getOfferingUser() {
        return offeringUser;
    }

    public void setOfferingUser(User offeringUser) {
        this.offeringUser = offeringUser;
    }

    public Catch getRequestedCatch() {
        return requestedCatch;
    }

    public void setRequestedCatch(Catch requestedCatch) {
        this.requestedCatch = requestedCatch;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}