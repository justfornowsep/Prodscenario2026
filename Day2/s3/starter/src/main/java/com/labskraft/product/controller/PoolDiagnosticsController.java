package com.labskraft.product.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;
import com.zaxxer.hikari.HikariDataSource;
import com.zaxxer.hikari.HikariPoolMXBean;

@RestController
public class PoolDiagnosticsController {
    private final DataSource dataSource;

    public PoolDiagnosticsController(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @GetMapping("/api/pool/status")
    public Map<String, Object> getPoolStatus() {
        // TODO for Participant:
        // Replace this placeholder with real pool diagnostics:
        //   1. If dataSource is an instance of HikariDataSource (com.zaxxer.hikari.HikariDataSource), use it
        //   2. Read the pool metrics through getHikariPoolMXBean():
        //        getActiveConnections(), getIdleConnections(), getTotalConnections(), getThreadsAwaitingConnection()
        //   3. Return them in a Map with the keys:
        //        activeConnections, idleConnections, totalConnections, threadsAwaitingConnection
        //   4. Keep a fallback that returns Map.of("status", "Not a Hikari DataSource") for any other DataSource
        if (dataSource instanceof HikariDataSource hikariDataSource) {

        HikariPoolMXBean pool = hikariDataSource.getHikariPoolMXBean();

        return Map.of(
            "activeConnections", pool.getActiveConnections(),
            "idleConnections", pool.getIdleConnections(),
            "totalConnections", pool.getTotalConnections(),
            "threadsAwaitingConnection", pool.getThreadsAwaitingConnection()
        );

        }

        return Map.of("status", "Not a Hikari DataSource");
    }

    @GetMapping("/api/pool/leak-test")
    public String leakTest() throws SQLException, InterruptedException {
        Connection conn = dataSource.getConnection();
        Thread.sleep(5000);
        conn.close();
        return "Connection acquired, used, and closed safely";
    }
}
