package com.example.demo.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.Commande;

public interface CommandeDAO extends JpaRepository<Commande, Integer>{

}
