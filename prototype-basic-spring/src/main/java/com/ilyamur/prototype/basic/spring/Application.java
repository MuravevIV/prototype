package com.ilyamur.prototype.basic.spring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class Application {

    private final static Logger LOG = LoggerFactory.getLogger(Application.class);

    /**
     * Main application body.
     */
    void run() {
        //
        try {
            Thread.sleep(Long.MAX_VALUE);
        } catch (InterruptedException ignored) {
        }
    }
}
