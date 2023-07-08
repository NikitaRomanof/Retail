package com.retail.repository;

import com.retail.model.entity.GroupSku;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GroupSkuRepository extends JpaRepository<GroupSku, Long> {
    Optional<GroupSku> findGroupSkuByGroupId(Long id);
}
