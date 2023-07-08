package com.retail.mapper;

import com.retail.model.dto.GroupSkuDto;
import com.retail.model.entity.GroupSku;

public class GroupSkuMapper extends GenericMapper<GroupSku, GroupSkuDto> {
    protected GroupSkuMapper() {
        super(GroupSku.class, GroupSkuDto.class);
    }
}
