package com.ilyamur.prototype.basic.spring;

import com.ilyamur.prototype.basic.spring.entity.Product;
import com.ilyamur.prototype.basic.spring.dto.ProductDto;
import com.ilyamur.prototype.basic.spring.provider.ProductProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Application {

    private final static Logger LOG = LoggerFactory.getLogger(Application.class);

    @Autowired
    private ProductProvider productFactory;

    /**
     * Main application body.
     */
    void run() {
        ProductDto productDto = new ProductDto();
        productDto.setId(1);
        productDto.setName("book");
        productDto.setPrice(10.00);
        Product product = productFactory.create(productDto);
        LOG.info(product.toString());
        try {
            Thread.sleep(Long.MAX_VALUE);
        } catch (InterruptedException ignored) {
        }
    }
}
