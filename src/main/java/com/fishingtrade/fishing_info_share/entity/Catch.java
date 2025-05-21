package com.fishingtrade.fishing_info_share.entity;

import jakarta.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "catches") // テーブル名を明示的に指定
public class Catch {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(nullable = false)
    private String location;

    @Column(nullable = false)
    private String species;

    @Column(nullable = false)
    private Integer count;

    @Column(nullable = false)
    private Timestamp caughtAt;

    @Column(nullable = false)
    private String tackle;

    // 必要に応じてゲッター、セッター、コンストラクタを追加してください。
    // 例：
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Timestamp getCaughtAt() {
        return caughtAt;
    }

    public void setCaughtAt(Timestamp caughtAt) {
        this.caughtAt = caughtAt;
    }

    public String getTackle() {
        return tackle;
    }

    public void setTackle(String tackle) {
        this.tackle = tackle;
    }
}