package com.fishingtrade.fishing_info_share.repository;

import com.fishingtrade.fishing_info_share.entity.SharedCatchDetails;
import com.fishingtrade.fishing_info_share.entity.SharedCatchDetails.SharedCatchDetailsId; // 複合主キー用のIDクラス（後で作成）
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SharedCatchDetailsRepository extends JpaRepository<SharedCatchDetails, SharedCatchDetailsId> {
    // 必要に応じてカスタムメソッドを追加
}