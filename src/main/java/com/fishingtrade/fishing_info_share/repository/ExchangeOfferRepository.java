package com.fishingtrade.fishing_info_share.repository;

import com.fishingtrade.fishing_info_share.entity.ExchangeOffer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExchangeOfferRepository extends JpaRepository<ExchangeOffer, Long> {
    // 必要に応じてカスタムメソッドを追加
}