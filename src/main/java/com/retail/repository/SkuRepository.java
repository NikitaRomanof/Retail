package com.retail.repository;

import com.retail.model.entity.Sku;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SkuRepository extends JpaRepository<Sku, Long> {
    Optional<Sku> findSkuBySkuId(Long skuId);
}
