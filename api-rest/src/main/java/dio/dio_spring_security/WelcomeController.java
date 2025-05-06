package dio.dio_spring_security;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.security.access.prepost.PreAuthorize;

public class WelcomeController{
    @GetMapping
    public String welcome(){
        return "Welcome to My Spring Boot Web API";
    }
    @GetMapping("/USERS")
    @PreAuthorize("hasAnyRole('MANAGERS', 'USERS')")
    public String users(){
        return "Authorized user";
    }
    @GetMapping("/MANAGERS")
    @PreAuthorize("hasRole('MANAGERS')")
    public String managers(){
        return "Authorized manager";
    }
}