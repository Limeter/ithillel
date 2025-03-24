package homework28;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
public class AppConfig {

    @Bean
    public Service service() {
        return new Service();
    }

    @Bean
    public Client client(Service service) {
        return new Client(service);
    }
}

@Component
class Service {
    public String getData() {
        return "Hello from Service!";
    }
}

@Component
class Client {
    private final Service service;

    public Client(Service service) {
        this.service = service;
    }

    public void doSomething() {
        System.out.println(service.getData());
    }
}