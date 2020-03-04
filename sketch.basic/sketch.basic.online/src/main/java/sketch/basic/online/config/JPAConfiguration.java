package sketch.basic.online.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EntityScan(basePackages = {
        jp.gtf.spring.core.Module.ENTITY,
        "jp.jphome.core.presistent.entity"})
@EnableJpaRepositories(basePackages = {
        jp.gtf.spring.core.Module.REPOSITORY,
        "jp.jphome.core.presistent.repository"})
public class JPAConfiguration {
}
