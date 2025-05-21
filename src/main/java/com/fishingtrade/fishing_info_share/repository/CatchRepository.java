package com.fishingtrade.fishing_info_share.repository;

import com.fishingtrade.fishing_info_share.entity.Catch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CatchRepository extends JpaRepository<Catch, Long> {
    // 必要に応じてカスタムメソッドを追加
}