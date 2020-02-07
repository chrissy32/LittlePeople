package littlepeople.application.repository;

import littlepeople.application.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query("SELECT u FROM User u WHERE u.email = :email")
    Optional<User> getUserByEmail(@Param("email") String email);

    Optional<User> findByUsername(String username);

    @Query("SELECT user FROM User user WHERE lower(user.city) = lower(:city) AND user.isAdmin = 0")
    List<User> getAllVolunteersFromCity(@Param("city") String city);
}
