package com.finanzas.finanzasback.controller;

import com.finanzas.finanzasback.domain.model.Reason;
import com.finanzas.finanzasback.domain.service.ReasonService;
import com.finanzas.finanzasback.resource.ReasonResource;
import com.finanzas.finanzasback.resource.SaveReasonResource;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

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

    @GetMapping("/reasons")
    public Page<ReasonResource> getAllReasons(Pageable pageable){
        Page<Reason> reasonPage = reasonService.getAllReasons(pageable);
        List<ReasonResource> resources = reasonPage.getContent()
                .stream()
                .map(this::convertToResource)
                .collect(Collectors.toList());

        return new PageImpl<>(resources, pageable, resources.size());
    }

    private Reason convertToEntity(SaveReasonResource resource) {
        return mapper.map(resource, Reason.class);
    }

    private ReasonResource convertToResource(Reason entity) {
        return mapper.map(entity, ReasonResource.class);
    }
}
