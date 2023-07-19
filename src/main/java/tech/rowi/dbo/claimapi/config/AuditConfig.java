package tech.rowi.dbo.claimapi.config;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import tech.rowi.dbo.claimapi.util.TokenUtil;

import java.util.Optional;

@Configuration
@EnableJpaAuditing
@RequiredArgsConstructor
public class AuditConfig {
    private final TokenUtil tokenUtil;

    @Bean
    public AuditorAware<String> aware() {
        return () -> Optional.of(tokenUtil.getUsername());
    }
}
