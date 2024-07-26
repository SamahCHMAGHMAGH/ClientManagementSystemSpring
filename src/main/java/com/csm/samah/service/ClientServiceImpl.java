 package com.csm.samah.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.csm.samah.model.Client;
import com.csm.samah.repository.ClientRepository;

//créer service dans Spring Boot
//une méthode qui va implémenter l'interface ClientService
@Service
public class ClientServiceImpl implements ClientService {
	
	//un objet ClientRepository pour faire les opérations save, update...
	private ClientRepository clientRepository;

	public ClientServiceImpl(ClientRepository clientRepository) {
		super();
		this.clientRepository = clientRepository;
	}

	//on utilise l'annotion Override pour l'injection des objets à l'interface service
	@Override
	public List<Client> getAllClients() {
		return clientRepository.findAll();
	}
	//une méthode pour enregistrer client, si l'id de client est null Spring va l'ajouter, il va faire un INSERT
	//en lui apportant un nouveau id, et si client a déjà un id il va lancé un update
	//donc save va jouer un double rôle 
	@Override
	public Client saveClient(Client client) {
		return clientRepository.save(client);
	}
	//une méthode pour récupérer client byId
	@Override
	public Client getClientById(Long id) {
		return clientRepository.findById(id).get();
	}


	@Override
	public Client updateClient(Client client) {
		return clientRepository.save(client);
	}


	@Override
	public void deleteClientById(Long id) {
		clientRepository.deleteById(id);
		
	}

}
