package com.labskraft.product.monitoring;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;
import java.util.Map;

// TODO for Participant (action item 4):
// Implement a custom Actuator endpoint:
//   1. Register this class as a Spring bean            -> @Component
//   2. Declare the endpoint id                         -> @Endpoint(id = "storeControl")
//   3. Add a method annotated with @ReadOperation that returns a status map, e.g. Map.of("status", "ACTIVE")
// (application.properties already exposes "storeControl" over the web.)
// Imports you will need:
//   org.springframework.boot.actuate.endpoint.annotation.Endpoint
//   org.springframework.boot.actuate.endpoint.annotation.ReadOperation
//   org.springframework.stereotype.Component
@Component
@Endpoint(id = "storeControl")
public class StoreControlEndpoint {

    @ReadOperation
    public Map<String, String> status() {
        return Map.of("status", "ACTIVE");
    }
}
