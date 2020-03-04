package sketch.basic.online;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(value = {
        "jp.gtf.spring.core",
        "jp.gtf.spring.config",
        "jp.gtf.spring.online",
        "sketch.basic.online",
        "sketch.basic.online.online"})
public class AppStart {

    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(AppStart.class);
        springApplication.run(args);
    }

}
