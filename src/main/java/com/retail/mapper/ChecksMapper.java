package com.retail.mapper;

import com.retail.model.dto.ChecksDto;
import com.retail.model.entity.Checks;
import com.retail.service.SkuService;
import com.retail.service.TransactionsService;
import jakarta.annotation.PostConstruct;


public class ChecksMapper extends GenericMapper<Checks, ChecksDto> {
    private final TransactionsService transactionsService;
    private final SkuService skuService;
    protected ChecksMapper(TransactionsService transactionsService, SkuService skuService) {
        super(Checks.class, ChecksDto.class);
        this.transactionsService = transactionsService;
        this.skuService = skuService;
    }

    @PostConstruct
    public void setupMapper() {
        mapper.createTypeMap(Checks.class, ChecksDto.class).setPostConverter(toDtoConverter());
        mapper.createTypeMap(ChecksDto.class, Checks.class).setPostConverter(toEntityConverter());
    }

    @Override
    protected void mapSpecificFieldsDtoToEntity(ChecksDto source, Checks destination) {
        Long transactionId = source.getTransactionId();
        Long skuId = source.getSkuId();
        destination.setTransactionId(transactionsService.getByIdOrElseThrow(transactionId));
        destination.setSkuId(skuService.getByIdOrElseThrow(skuId));
    }

    @Override
    protected void mapSpecificFieldsEntityToDto(Checks source, ChecksDto destination) {
        destination.setId(source.getId());
        destination.setTransactionId(source.getTransactionId().getTransactionId());
        destination.setSkuId(source.getSkuId().getSkuId());
        destination.setSkuAmount(source.getSkuAmount());
        destination.setSkuSumm(source.getSkuSummPaid());
        destination.setSkuDiscount(source.getSkuDiscount());
        destination.setSkuSummPaid(source.getSkuSummPaid());
    }
}
