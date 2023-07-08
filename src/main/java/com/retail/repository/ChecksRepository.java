package com.retail.repository;

import com.retail.model.entity.Checks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ChecksRepository extends JpaRepository<Checks, Long> {
    Optional<Checks> findChecksById(Long id);
}
