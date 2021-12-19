package com.example.demo.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.Client;


public interface ClientDAO extends JpaRepository<Client, Integer>{

}
