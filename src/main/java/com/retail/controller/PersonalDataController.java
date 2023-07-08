package com.retail.controller;

import com.retail.mapper.PersonalDataMapper;
import com.retail.model.dto.PersonalDataDto;
import com.retail.model.entity.PersonalData;
import com.retail.service.PersonalDataService;
import jakarta.validation.constraints.NotNull;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class PersonalDataController {
    private final PersonalDataService service;
    private final PersonalDataMapper mapper;

    public PersonalDataController(PersonalDataService service, PersonalDataMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @GetMapping("/personal")
    public String getAllCard(@NotNull Model model) {

        List<PersonalData> models = service.getAllPersonalData();
        List<PersonalDataDto> dtos = mapper.toDtos(models);
        model.addAttribute("personal", dtos);
        return "personal";
    }
}
