package com.ilyamur.prototype.basic.spring.domain;

import com.ilyamur.prototype.basic.spring.domain.dto.ProductDto;
import com.ilyamur.prototype.basic.spring.service.DiscountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class ProductImpl implements Product {

    private ProductDto dto;

    @Autowired
    private DiscountService discountService;

    @Override
    public void setDto(ProductDto dto) {
        this.dto = dto;
    }

    @Override
    public String toString() {
        double salePrice = dto.getPrice();
        double discountPrice = salePrice * (1 - discountService.getDiscount());

        return "Product{id=" + dto.getId() + ", name=" + dto.getName() + ", salePrice=" + salePrice
                + ", discountPrice=" + discountPrice + "}";
    }
}
