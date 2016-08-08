package com.ilyamur.prototype.basic.spring.domain.factory;

import com.ilyamur.prototype.basic.spring.domain.Product;
import com.ilyamur.prototype.basic.spring.domain.dto.ProductDto;

public interface ProductFactory {

    Product create(ProductDto dto);
}
