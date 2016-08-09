package com.ilyamur.prototype.basic.spring.service.impl;

import com.ilyamur.prototype.basic.spring.service.DiscountService;
import org.springframework.stereotype.Component;

@Component
public class DiscountServiceImpl implements DiscountService {

    @Override
    public double getDiscount() {
        return 0.05;
    }
}
