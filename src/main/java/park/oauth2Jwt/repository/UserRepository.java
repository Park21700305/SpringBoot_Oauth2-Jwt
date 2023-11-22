package park.oauth2Jwt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import park.oauth2Jwt.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
