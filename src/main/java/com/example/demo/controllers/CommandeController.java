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
	    
	    @RequestMapping("/removeCommande/{id}")    
	    public String clientRemove(@PathVariable("id") int id,Model model){    
	    	//get the informatios of the client that should be updated
	    	model.addAttribute("commande",commandeService.getCommande(id));  
	        return "deleteCommande";    
	    }
	    
	    
	    @RequestMapping(value="/deleteCommande",method = RequestMethod.POST)    
	    public String clientDelete(@ModelAttribute("commande") Commande commande){    
	    	//save the client updated
	    	Integer clientId=commande.client.getId();
	        commandeService.deleteCommande(commande.getNumero_command());
	        return "redirect:/commandes/"+clientId;
	    }
	    
	    
	    @RequestMapping("/editCommande/{id}")    
	    public String editCommande(@PathVariable("id") int id,Model model){    
	    	//send the object of commande to be changed in the form
	    	model.addAttribute("commande",commandeService.getCommande(id));  
	        return "editCommande";    
	    }
	    
	    //update the commande to the DB
	    @RequestMapping(value="/updateCommande",method = RequestMethod.POST)    
	    public String updateCommande(@ModelAttribute("commande") Commande commande){    
	    	//save the client 
	        commandeService.updateCommande(commande);    
	        return "redirect:/commandes/"+commande.client.getId();
	    }
}
