package com.ilyamur.prototype.basic.spring.factory.impl;

import com.ilyamur.prototype.basic.spring.entity.Product;
import com.ilyamur.prototype.basic.spring.dto.ProductDto;
import com.ilyamur.prototype.basic.spring.factory.ProductFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class ProductFactoryImpl implements ProductFactory {

    @Autowired
    private ApplicationContext ctx;

    @Override
    public Product create(ProductDto dto) {
        Product product = ctx.getBean(Product.class);
        product.setDto(dto);
        return product;
    }
}
