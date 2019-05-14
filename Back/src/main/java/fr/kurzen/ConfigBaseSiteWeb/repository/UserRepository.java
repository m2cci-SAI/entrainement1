package fr.kurzen.ConfigBaseSiteWeb.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.kurzen.ConfigBaseSiteWeb.model.User;

public interface UserRepository extends JpaRepository<User, Long>{

	Optional<User> findByPseudo(String pseudo);

}
