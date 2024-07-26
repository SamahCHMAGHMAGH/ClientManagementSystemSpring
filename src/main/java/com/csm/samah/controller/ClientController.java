package com.csm.samah.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.csm.samah.model.Client;
import com.csm.samah.service.ClientService;


@Controller
public class ClientController {
	
	private ClientService clientService;

	public ClientController(ClientService clientService) {
		super();
		this.clientService = clientService;
	}
	
	//une méthode pour gérer la liste des clients avec le retour à view
	@GetMapping("/clients")
	public String listClients(Model model) {
		model.addAttribute("clients", clientService.getAllClients());
		return "clients";
	}
//cette requête vient de la page clients.html
@GetMapping("/clients/new")	
public String createClientForm(Model model) {
	
	//créer un objet client pour conserver les données du formulaire de client
	Client client = new Client();
	model.addAttribute("client", client);
	return "create_client";
}	
//une méthode pour enregistrer le client dans une base de données
@PostMapping("/clients")
public String saveClient(@ModelAttribute("client") Client client) {
	clientService.saveClient(client);
	return "redirect:/clients";
	}

@GetMapping("/clients/edit/{id}")
//une méthode pour éditer un client  
//l'annotation @PathVariable c'est pour récupérer l'id
public String editClientForm(@PathVariable Long id, Model model) {
	model.addAttribute("client", clientService.getClientById(id));
	return "edit_client";
	
}
//après l'édition de client on va gérer la requête update client avec cette méthode
@PostMapping("/clients/{id}")
public String updateClient(@PathVariable Long id,
		@ModelAttribute("client") Client client,
		Model model) {
	
	//récupérer client de la base de données avec id
	Client existingClient = clientService.getClientById(id);
	existingClient.setId(id);
	existingClient.setFirstName(client.getFirstName());
	existingClient.setLastName(client.getLastName());
	existingClient.setEmail(client.getEmail());
	
	//enregistrer l'objet "update client"
	clientService.updateClient(existingClient);
	return "redirect:/clients";
	}
//gérer la requête delete client avec cette méthode
@GetMapping("/clients/{id}")
public String deleteClient(@PathVariable Long id) {
	clientService.deleteClientById(id);
	return "redirect:/clients";
	
}
}