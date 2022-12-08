/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.app.startmovie.interfaces;

import com.app.startmovie.entities.Client;
import org.springframework.data.mongodb.repository.MongoRepository;


/**
 *
 * @author Andres
 */
public interface IClientRepository extends MongoRepository<Client, String> {
    
}
