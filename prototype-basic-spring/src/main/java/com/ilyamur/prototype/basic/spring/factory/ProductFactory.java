package com.ilyamur.prototype.basic.spring.factory;

import com.ilyamur.prototype.basic.spring.entity.Product;
import com.ilyamur.prototype.basic.spring.dto.ProductDto;

public interface ProductFactory {

    Product create(ProductDto dto);
}
