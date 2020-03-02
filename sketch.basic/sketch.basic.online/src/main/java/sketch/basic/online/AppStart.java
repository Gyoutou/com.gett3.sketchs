package sketch.basic.online;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(value = {
        "sketch.basic.online",
        "sketch.basic.online.online"})
public class AppStart {

    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(AppStart.class);
        springApplication.run(args);
    }

}
