package com.retail.mapper;

import com.retail.model.dto.CardDto;
import com.retail.model.entity.Card;
import com.retail.model.entity.PersonalData;
import com.retail.service.PersonalDataService;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;


@Component
public class CardMapper extends GenericMapper<Card, CardDto> {
    private final PersonalDataService personalDataService;
    protected CardMapper(PersonalDataService personalDataService) {
        super(Card.class, CardDto.class);
        this.personalDataService = personalDataService;
    }
    @PostConstruct
    public void setupMapper() {
        mapper.createTypeMap(Card.class, CardDto.class).setPostConverter(toDtoConverter());
        mapper.createTypeMap(CardDto.class, Card.class).setPostConverter(toEntityConverter());
    }

    @Override
    protected void mapSpecificFieldsDtoToEntity(CardDto source, Card destination) {
        Long idCard = source.getIdCard();
        PersonalData customerId = personalDataService.getByIdOrElseThrow(idCard);
        destination.setCustomerId(customerId);
    }

    @Override
    protected void mapSpecificFieldsEntityToDto(Card source, CardDto destination) {
        destination.setIdCard(source.getCustomerCardId());
        destination.setIdCustomer(source.getCustomerId().getCustomerId());
        destination.setSurnameCustomer(source.getCustomerId().getCustomerSurname());
    }
}
