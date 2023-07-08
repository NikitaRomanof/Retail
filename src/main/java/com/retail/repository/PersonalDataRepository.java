package com.retail.repository;

import com.retail.model.entity.PersonalData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonalDataRepository extends JpaRepository<PersonalData, Long> {

    Optional<PersonalData> findPersonalDataByCustomerId(Long CustomerId);
}
