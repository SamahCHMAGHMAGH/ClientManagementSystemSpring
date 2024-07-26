package com.csm.samah.repository;


import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

import com.csm.samah.model.Client;

//chaque entité que je crée dans Spring Boot, il faut créer aussi son interface Repository
//cette interface dispose de toutes les opérations de base sur les données automatiquement
//pour tout ce qui est save, update, delete...

public interface ClientRepository extends JpaRepository<Client, Long>{
	
	
	Optional<Client> findById(long id);

}
