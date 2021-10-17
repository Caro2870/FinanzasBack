package com.finanzas.finanzasback.controller;

import com.finanzas.finanzasback.domain.model.Rate;
import com.finanzas.finanzasback.domain.service.RateService;
import com.finanzas.finanzasback.resource.RateResource;
import com.finanzas.finanzasback.resource.SaveRateResource;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class RateController {
    @Autowired
    private RateService rateService;

    @Autowired
    private ModelMapper mapper;


    @PostMapping("/rates")
    public RateResource createReate(@Valid @RequestBody SaveRateResource resource) {
        Rate rate = convertToEntity(resource);

        return convertToResource(rateService.createRate(rate));
    }

    private Rate convertToEntity(SaveRateResource resource) {
        return mapper.map(resource, Rate.class);
    }

    private RateResource convertToResource(Rate entity) {
        return mapper.map(entity, RateResource.class);
    }
}
