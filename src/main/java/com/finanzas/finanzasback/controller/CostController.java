package com.finanzas.finanzasback.controller;

import com.finanzas.finanzasback.domain.model.Cost;
import com.finanzas.finanzasback.domain.service.CostService;
import com.finanzas.finanzasback.resource.CostResource;
import com.finanzas.finanzasback.resource.SaveCostResource;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class CostController {
    @Autowired
    private CostService costService;

    @Autowired
    private ModelMapper mapper;


    @PostMapping("/cost/reasons/{reasonId}/fee_recepeit/{fee_recepeitId}")
    public CostResource createCost(@Valid @RequestBody SaveCostResource resource, @PathVariable Long reasonId, @PathVariable Long fee_recepeitId) {
        Cost cost = convertToEntity(resource);

        return convertToResource(costService.createCost(cost,reasonId,fee_recepeitId));
    }

    @GetMapping("/{costId}/cost/")
    public CostResource getCostById(@PathVariable Long costId) {
        return convertToResource(costService.getCostById(costId));
    }
    private Cost convertToEntity(SaveCostResource resource) {
        return mapper.map(resource, Cost.class);
    }

    private CostResource convertToResource(Cost entity) {
        return mapper.map(entity, CostResource.class);
    }
}
