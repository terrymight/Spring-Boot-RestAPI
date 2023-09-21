package net.dipbits.dipbitsRestApi.repository;

import net.dipbits.dipbitsRestApi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    @Query(name="select u from User u where u.email = :email", nativeQuery = false)
    // User findByEmail(String email);
    Optional<User> findByEmail(String email);
}
