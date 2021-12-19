package com.example.demo.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class Commande {
      
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer numero_command;
	
	@Column
	private String  nom_commande;
	
	@Column
	private String  type_command;
	
    public Integer getNumero_command() {
		return numero_command;
	}

	public void setNumero_command(Integer numero_command) {
		this.numero_command = numero_command;
	}

	public String getNom_commande() {
		return nom_commande;
	}

	public void setNom_commande(String nom_commande) {
		this.nom_commande = nom_commande;
	}

	public String getType_command() {
		return type_command;
	}

	public void setType_command(String type_command) {
		this.type_command = type_command;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id", nullable = false)
    public Client client;
    
}
