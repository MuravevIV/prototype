package com.ilyamur.prototype.basic.spring;

import com.ilyamur.prototype.basic.spring.component.ExampleComponent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Application {

    private final static Logger LOG = LoggerFactory.getLogger(Application.class);

    @Autowired
    private ExampleComponent exampleComponent;

    /**
     * Main application body.
     */
    void run() {
        String message = exampleComponent.getMessage();
        LOG.info(message);
        try {
            Thread.sleep(Long.MAX_VALUE);
        } catch (InterruptedException ignored) {
        }
    }
}
