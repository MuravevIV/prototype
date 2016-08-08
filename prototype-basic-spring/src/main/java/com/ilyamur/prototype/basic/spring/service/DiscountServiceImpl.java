package com.ilyamur.prototype.basic.spring.service;

import org.springframework.stereotype.Component;

@Component
public class DiscountServiceImpl implements DiscountService {

    @Override
    public double getDiscount() {
        return 0.05;
    }
}
