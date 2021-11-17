package com.finanzas.finanzasback.controller;

import com.finanzas.finanzasback.domain.model.FeeReceipt;
import com.finanzas.finanzasback.domain.service.FeeReceiptService;
import com.finanzas.finanzasback.resource.FeeReceiptResource;
import com.finanzas.finanzasback.resource.SaveFeeReceiptResource;
import com.finanzas.finanzasback.resource.UserResource;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class FeeReceiptsController {

    @Autowired
    private FeeReceiptService feeReceiptService;

    @Autowired
    private ModelMapper mapper;


    @PostMapping("/feeRecepeit/rates/{rateId}/wallet/{walletId}")
    public FeeReceiptResource createFeeRecepeit(@Valid @RequestBody SaveFeeReceiptResource resource,@PathVariable Long rateId,@PathVariable Long walletId) {
        FeeReceipt feeReceipt = convertToEntity(resource);

        return convertToResource(feeReceiptService.createFeeReceipt(feeReceipt,rateId,walletId));
    }

    @GetMapping("/{feeRecepeitId}/feeRecepeit/")
    public FeeReceiptResource getFeeRecepeitById(@PathVariable Long feeRecepeitId) {
        return convertToResource(feeReceiptService.getFeeReceiptById(feeRecepeitId));
    }


    @PutMapping("/rates/{rateId}/wallets/{walletId}/feeReceipts/{feeReceiptId}")
    public FeeReceiptResource updateFeeReceipt(
            @PathVariable Long rateId,
            @PathVariable Long walletId,
            @PathVariable Long feeReceiptId,
            @Valid @RequestBody SaveFeeReceiptResource resource) {
        return convertToResource(feeReceiptService.updateFeeReceipt(feeReceiptId,rateId,walletId,convertToEntity(resource)));
    }

    private FeeReceipt convertToEntity(SaveFeeReceiptResource resource) {
        return mapper.map(resource, FeeReceipt.class);
    }

    private FeeReceiptResource convertToResource(FeeReceipt entity) {
        return mapper.map(entity, FeeReceiptResource.class);
    }
}
