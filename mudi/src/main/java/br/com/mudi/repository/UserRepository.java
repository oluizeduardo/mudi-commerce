package br.com.mudi.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.mudi.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	Optional<User> findByLogin(String username);
	
	@Query("SELECT u FROM User u JOIN FETCH u.profiles WHERE u.id = :id")
	Optional<User> findByIdWithProfile(Long id);
}
