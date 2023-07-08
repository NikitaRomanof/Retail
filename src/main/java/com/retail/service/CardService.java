package com.retail.service;

import com.retail.model.entity.Card;
import com.retail.model.entity.PersonalData;
import com.retail.repository.CardRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardService {
    private final CardRepository repository;

    public CardService(CardRepository repository) {
        this.repository = repository;
    }

    public List<Card> getAllCard() {
        return repository.findAll();
    }

    public Card getByIdOrElseThrow(Long id) {
        return repository.findCardByCustomerCardId(id)
                .orElseThrow(() -> new IllegalArgumentException(
                        String.format("Card with id '%d' not found", id)));
    }
}
