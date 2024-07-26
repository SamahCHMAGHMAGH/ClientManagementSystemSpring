package com.csm.samah.service;

import java.util.List;

import com.csm.samah.model.Client;

//on va créer l'interface Service avec les méthodes de Repository(méthode CRUD)
//Spring va injecter les méthodes avec leurs annotations dans la classe ClientServieImpl
//ou bien, on peut faire l'inverse : on déclare les méthodes dans la classe ClientServiceImpl 
//et Spring va les injecter dans l'interface ClientService 
public interface ClientService {

	List<Client> getAllClients();

	Client saveClient(Client client);
	 
	Client getClientById(Long id);
	
	Client updateClient(Client client);
	
	void deleteClientById(Long id);

}
