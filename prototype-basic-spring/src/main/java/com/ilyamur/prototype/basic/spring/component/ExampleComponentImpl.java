package com.ilyamur.prototype.basic.spring.component;

import org.springframework.stereotype.Component;

@Component
public class ExampleComponentImpl implements ExampleComponent {

    @Override
    public String getMessage() {
        return "example message";
    }
}
