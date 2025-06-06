package dio.dio_spring_security.init;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import dio.dio_spring_security.model.UserDio;
import dio.dio_spring_security.repository.UserRepository;
import jakarta.transaction.Transactional;

@Component
public class StartApplication implements CommandLineRunner {
    @Autowired
    private UserRepository repository;
    @Transactional
    @Override
    public void run(String ... args) throws Exception{
        UserDio user = repository.findByUsername("admin");
        if(user == null){
            user = new UserDio();
            user.setName("ADMIN");
            user.setUsername("admin");
            user.setPassword ("master123");
            user.getRoles().add("MANAGERS");
            repository.save(user);
        }
        user = repository.findByUsername("user");
        if(user == null){
            user = new UserDio();
            user.setName("USER");
            user.setUsername("user");
            user.setPassword("user123");
            user.getRoles().add("USERS");
            repository.save(user);
        }
    }
}