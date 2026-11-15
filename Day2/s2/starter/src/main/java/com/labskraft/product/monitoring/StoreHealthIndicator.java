package com.labskraft.product.monitoring;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

// TODO for Participant (action item 3):
// Implement a custom health indicator:
//   1. Register this class as a Spring bean            -> @Component
//   2. Implement the HealthIndicator interface
//   3. Override health() so it returns Health.up()
// Imports you will need:
//   org.springframework.boot.actuate.health.Health
//   org.springframework.boot.actuate.health.HealthIndicator
//   org.springframework.stereotype.Component
@Component
public class StoreHealthIndicator implements HealthIndicator{ 
    
    @Override
    public Health health() {
        return Health.up().build();
    }

}
