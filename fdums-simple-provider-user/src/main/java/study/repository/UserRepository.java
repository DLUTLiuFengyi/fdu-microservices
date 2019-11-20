package study.repository;

import org.springframework.boot.json.JacksonJsonParser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import study.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
