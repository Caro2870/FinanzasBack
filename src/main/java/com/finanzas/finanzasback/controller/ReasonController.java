package com.finanzas.finanzasback.controller;

import com.finanzas.finanzasback.domain.model.Reason;
import com.finanzas.finanzasback.domain.service.ReasonService;
import com.finanzas.finanzasback.resource.ReasonResource;
import com.finanzas.finanzasback.resource.SaveReasonResource;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class ReasonController {
    @Autowired
    private ReasonService reasonService;

    @Autowired
    private ModelMapper mapper;


    @PostMapping("/reasons")
    public ReasonResource createReate(@Valid @RequestBody SaveReasonResource resource) {
        Reason reason = convertToEntity(resource);

        return convertToResource(reasonService.createReason(reason));
    }

    private Reason convertToEntity(SaveReasonResource resource) {
        return mapper.map(resource, Reason.class);
    }

    private ReasonResource convertToResource(Reason entity) {
        return mapper.map(entity, ReasonResource.class);
    }
}
