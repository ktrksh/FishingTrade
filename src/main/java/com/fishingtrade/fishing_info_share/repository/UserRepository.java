package com.fishingtrade.fishing_info_share.repository;

import com.fishingtrade.fishing_info_share.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> { // Long は User エンティティの ID の型に合わせてください
    User findByEmail(String email);
}