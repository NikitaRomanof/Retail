package com.retail.model.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "scu", schema = "public")
public class Sku {
    @Id
    @GeneratedValue
    @Column(name = "sku_id")
    private Long skuId;
    @Column(name = "sku_name", nullable = false)
    private String skuName;
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "group_id", referencedColumnName = "group_id", nullable = false)
    private GroupSku groupId;

    public Sku(Long skuId, String skuName, GroupSku groupId) {
        this.skuId = skuId;
        this.skuName = skuName;
        this.groupId = groupId;
    }

    public Sku() {
    }

    public Long getSkuId() {
        return skuId;
    }

    public void setSkuId(Long skuId) {
        this.skuId = skuId;
    }

    public String getSkuName() {
        return skuName;
    }

    public void setSkuName(String skuName) {
        this.skuName = skuName;
    }

    public GroupSku getGroupId() {
        return groupId;
    }

    public void setGroupId(GroupSku groupId) {
        this.groupId = groupId;
    }
}
