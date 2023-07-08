package com.retail.service;

import com.retail.model.entity.Card;
import com.retail.model.entity.Checks;
import com.retail.repository.ChecksRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChecksService {
    private final ChecksRepository repository;

    public ChecksService(ChecksRepository repository) {
        this.repository = repository;
    }

    public List<Checks> getAllChecks() {
        return repository.findAll();
    }

    public Checks getByIdOrElseThrow(Long id) {
        return repository.findChecksById(id)
                .orElseThrow(() -> new IllegalArgumentException(
                        String.format("Checks with id '%d' not found", id)));
    }
}
