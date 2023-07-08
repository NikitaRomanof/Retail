package com.retail.service;

import com.retail.model.entity.GroupSku;
import com.retail.repository.GroupSkuRepository;

import java.util.List;

public class GroupSkuService {
    private final GroupSkuRepository groupSkuRepository;

    public GroupSkuService(GroupSkuRepository groupSkuRepository) {
        this.groupSkuRepository = groupSkuRepository;
    }

    public List<GroupSku> getAllGroupSku() {
        return groupSkuRepository.findAll();
    }

    public GroupSku getGroupSkuById(Long idGroupSku) {
        return groupSkuRepository.findGroupSkuByGroupId(idGroupSku)
                .orElseThrow(() -> new IllegalArgumentException(
                        String.format("GroupSku with id '%d' not found", idGroupSku)));
    }
}
