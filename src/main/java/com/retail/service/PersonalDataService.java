package com.retail.service;

import com.retail.model.entity.PersonalData;
import com.retail.repository.PersonalDataRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonalDataService {
    private final PersonalDataRepository personalDataRepository;

    public PersonalDataService(PersonalDataRepository repository) {
        personalDataRepository = repository;
    }

    public PersonalData getByIdOrElseThrow(Long id) {
        return personalDataRepository.findPersonalDataByCustomerId(id)
                .orElseThrow(() -> new IllegalArgumentException(
                        String.format("PersonalData with id '%d' not found", id)));
    }

    public List<PersonalData> getAllPersonalData() {
        return personalDataRepository.findAll();
    }

}
