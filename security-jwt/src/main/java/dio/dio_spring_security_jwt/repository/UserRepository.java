package dio.dio_spring_security_jwt.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import dio.dio_spring_security_jwt.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public class UserRepository extends JpaRepository<User, Integer>{
    @Query("SELECT e FROM User e JOIN FETCH e.roles WHERE e.username = (:username)")
    public User findByUsername(@Param("username") String username);

    boolean existsByUsername(String username);
}