package com.ilyamur.prototype.basic.spring.domain.factory;

import com.ilyamur.prototype.basic.spring.domain.Product;
import com.ilyamur.prototype.basic.spring.domain.dto.ProductDto;
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
