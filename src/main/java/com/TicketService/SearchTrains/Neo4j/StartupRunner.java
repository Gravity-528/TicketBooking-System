package com.TicketService.SearchTrains.Neo4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class StartupRunner implements CommandLineRunner {

    @Value("${app.migration.enabled}")
    private boolean migrationEnabled;

    @Autowired
    private final MigrationService service;

    public StartupRunner(MigrationService service) {
        this.service = service;
    }

    @Override
    public void run(String... args) throws Exception {
        if (migrationEnabled) {
            service.migrate();
        }
    }
}

