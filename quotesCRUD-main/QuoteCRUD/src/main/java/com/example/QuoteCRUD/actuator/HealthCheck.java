package com.example.QuoteCRUD.actuator;


import org.springframework.boot.actuate.health.AbstractHealthIndicator;
import org.springframework.boot.actuate.health.Health;
import org.springframework.stereotype.Component;
import java.time.LocalDateTime;

@Component
public class HealthCheck extends AbstractHealthIndicator {

    @Override
    protected void doHealthCheck(Health.Builder builder) throws Exception {
        boolean running = false;
        int minnow = LocalDateTime.now().getMinute();

        if (minnow % 2 == 0) {
            builder.up();
        } else {
            builder.down();
        }

    }
}
