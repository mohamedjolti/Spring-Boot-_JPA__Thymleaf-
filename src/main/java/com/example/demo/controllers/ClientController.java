package com.example.demo.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.models.Client;
import com.example.demo.services.ClientService;

@Controller
public class ClientController {
   
	@Autowired
	ClientService clientService;
	
    @RequestMapping("/")
    public String viewemp(Model model){    
        ArrayList<Client> clientList=clientService.getAll();    
        model.addAttribute("clients",clientList);  
        return "list.html";    
    }  
    
    @RequestMapping("/formClient")    
    public String clientform(Model model){    
    	//send an empty object of client to be filled in the form
    	model.addAttribute("client",new Client());  
        return "addClient";    
    }
    
    
    @RequestMapping(value="/addclient",method = RequestMethod.POST)    
    public String save(@ModelAttribute("client") Client client){    
    	//save the client 
        clientService.addClient(client);    
        return "redirect:/";
    }
    @RequestMapping("/editClient/{id}")    
    public String clientEdit(@PathVariable("id") int id,Model model){    
    	//get the informatios of the client that should be updated
    	model.addAttribute("client",clientService.getClient(id));  
        return "editClient";    
    }
    
    
    @RequestMapping(value="/updateClient",method = RequestMethod.POST)    
    public String clientUpdate(@ModelAttribute("client") Client client){    
    	//save the client updated
        clientService.updateClient(client);    
        return "redirect:/";
    }
	
}
