package itmo.aulouu.inf.sec.lab1.repository;

import itmo.aulouu.inf.sec.lab1.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String login);
}
