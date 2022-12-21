package org.spring.foto.repo;

import java.util.Optional;
import org.spring.foto.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {
	
	Optional<User> findByUsername(String username);
	
}
