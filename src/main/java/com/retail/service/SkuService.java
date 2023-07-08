package com.retail.service;

import com.retail.model.entity.Sku;
import com.retail.repository.SkuRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SkuService {
    private final SkuRepository repository;

    public SkuService(SkuRepository repository) {
        this.repository = repository;
    }

    public List<Sku> getAllSku() {
        return repository.findAll();
    }

    public Sku getByIdOrElseThrow(Long id) {
        return repository.findSkuBySkuId(id)
                .orElseThrow(() -> new IllegalArgumentException(
                        String.format("Sku with id '%d' not found", id)));
    }
}
