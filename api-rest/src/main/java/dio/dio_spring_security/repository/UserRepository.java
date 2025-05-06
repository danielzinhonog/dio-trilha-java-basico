package dio.dio_spring_security.repository;

import dio.dio_spring_security.model.UserDio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<UserDio, Integer>{
    @Query("SELECT e FROM UserDio e JOIN FETCH e.roles WHERE e.username = :username")
    UserDio findByUsername(@Param("username") String username);
}