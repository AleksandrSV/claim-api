package tech.rowi.dbo.claimapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableFeignClients
@EnableJpaAuditing
@EnableTransactionManagement
@SpringBootApplication
@ConfigurationPropertiesScan
public class ClaimApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(ClaimApiApplication.class, args);
    }
}