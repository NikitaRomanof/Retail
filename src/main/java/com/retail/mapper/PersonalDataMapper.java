package com.retail.mapper;

import com.retail.model.dto.PersonalDataDto;
import com.retail.model.entity.PersonalData;
import org.springframework.stereotype.Component;


@Component
public class PersonalDataMapper extends GenericMapper<PersonalData, PersonalDataDto> {
    protected PersonalDataMapper() {
        super(PersonalData.class, PersonalDataDto.class);
    }
}
