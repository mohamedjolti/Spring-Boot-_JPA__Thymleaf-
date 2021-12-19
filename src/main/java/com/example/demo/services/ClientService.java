package com.example.demo.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.DAO.ClientDAO;
import com.example.demo.models.Client;

//the service  for the consuming the DAO interface 
@Service
public class ClientService {
      
	@Autowired
	ClientDAO clientDAO;
	
	//get the clients and consume the service
	public ArrayList<Client> getAll(){
		ArrayList<Client> clientList=new ArrayList<>();
		clientDAO.findAll().forEach(client->clientList.add(client));
		return clientList;
	}
	
	public void addClient(Client client) {
		clientDAO.save(client);
	}
	 
	public Client getClient(Integer clientId) {
		return clientDAO.findById(clientId).get();
	}
	public void updateClient(Client client) {
		clientDAO.save(client);
	}
	public void deleteClient(Integer clientId) {
		clientDAO.deleteById(clientId);
	}
	
}
