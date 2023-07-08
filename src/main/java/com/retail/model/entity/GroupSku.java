package com.retail.model.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "groups_sku", schema = "public")
public class GroupSku {
    @Id
    @GeneratedValue
    @Column(name = "group_id")
    private Long groupId;
    @Column(name = "group_name", nullable = false)
    private String groupName;

    public GroupSku() {
    }

    public GroupSku(Long groupId, String groupName) {
        this.groupId = groupId;
        this.groupName = groupName;
    }

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }
}
