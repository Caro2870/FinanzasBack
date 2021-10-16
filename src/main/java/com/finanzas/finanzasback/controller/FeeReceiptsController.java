package com.finanzas.finanzasback.controller;

import com.finanzas.finanzasback.domain.model.FeeReceipt;
import com.finanzas.finanzasback.domain.service.FeeReceiptService;
import com.finanzas.finanzasback.resource.FeeReceiptResource;
import com.finanzas.finanzasback.resource.SaveFeeReceiptResource;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class FeeReceiptsController {

    @Autowired
    private FeeReceiptService feeReceiptService;

    @Autowired
    private ModelMapper mapper;


    @PostMapping("/feeRecepeit")
    public FeeReceiptResource createFeeRecepeit(@Valid @RequestBody SaveFeeReceiptResource resource) {
        FeeReceipt feeReceipt = convertToEntity(resource);

        return convertToResource(feeReceiptService.createFeeReceipt(feeReceipt));
    }

    private FeeReceipt convertToEntity(SaveFeeReceiptResource resource) {
        return mapper.map(resource, FeeReceipt.class);
    }

    private FeeReceiptResource convertToResource(FeeReceipt entity) {
        return mapper.map(entity, FeeReceiptResource.class);
    }
}
