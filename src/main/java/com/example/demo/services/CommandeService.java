package com.example.demo.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.DAO.CommandeDAO;
import com.example.demo.models.Commande;

@Service
public class CommandeService {
	
	@Autowired
	CommandeDAO commandeDAO;
	
	
	public void addCommande(Commande commande) {
		commandeDAO.save(commande);
	}
	
	public Commande getCommande(Integer numero_command) {
		return commandeDAO.getById(numero_command);
	}
	
	public void deleteCommande(Integer numero_command) {
		commandeDAO.deleteById(numero_command);;
	}
	
	public void updateCommande(Commande commande) {
		commandeDAO.save(commande);
	}
     
	
	
	

}
