package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.models.Client;
import com.example.demo.models.Commande;
import com.example.demo.services.ClientService;
import com.example.demo.services.CommandeService;

@Controller
public class CommandeController {
        
	   @Autowired
	   CommandeService commandeService;
	   @Autowired 
	   ClientService clientService;
	    @RequestMapping("/commandeForm/{id}")    
	    public String commandeform(@PathVariable("id") int id,Model model){    
	    	//send an empty object of client to be filled in the form
	    	Commande commande=new Commande();
	    	commande.setClient(clientService.getClient(id));
	    	model.addAttribute("commande",commande);  
	        return "addCommande";    
	    }
	    
	    //add the client to the DB
	    @RequestMapping(value="/addCommande",method = RequestMethod.POST)    
	    public String save(@ModelAttribute("commande") Commande commande){    
	    	//save the client 
	        commandeService.addCommande(commande);    
	        return "redirect:/commandes/"+commande.client.getId();
	    }
	    
	    @RequestMapping("/removeCommande/{numero_command}")    
	    public String clientRemove(@PathVariable("numero_command") int numero_command,Model model){    
	    	//get the informatios of the client that should be updated
	    	model.addAttribute("commande",commandeService.getCommande(numero_command));  
	        return "deleteCommande";    
	    }
	    
	    
	    @RequestMapping(value="/deleteCommande",method = RequestMethod.POST)    
	    public String clientDelete(@ModelAttribute("commande") Commande commande){    
	    	//save the client updated
	        commandeService.deleteCommande(commande.getNumero_command());    
	        return "redirect:/";
	    }
}
