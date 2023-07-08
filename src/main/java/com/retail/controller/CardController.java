package com.retail.controller;

import com.retail.mapper.CardMapper;
import com.retail.model.dto.CardDto;
import com.retail.model.entity.Card;
import com.retail.service.CardService;
import jakarta.validation.constraints.NotNull;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class CardController {
    private final CardService service;
    private final CardMapper mapper;

    public CardController(CardService service, CardMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @GetMapping("/card")
    public String getAllCard(@NotNull Model model) {

        List<Card> models = service.getAllCard();
        List<CardDto> dtos = mapper.toDtos(models);
        model.addAttribute("cards", dtos);
        return "card";
    }
}
