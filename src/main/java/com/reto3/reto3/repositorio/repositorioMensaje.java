/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.reto3.reto3.repositorio;

import com.reto3.reto3.interfaces.interfaceMensaje;
import com.reto3.reto3.tablas.Mensaje;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class repositorioMensaje {
    
    @Autowired
    private interfaceMensaje crud3;
    
    public List<Mensaje> getAll() {
        return (List<Mensaje>) crud3.findAll();
    }
    
    public Optional<Mensaje> getMessage(int id) {
        return crud3.findById(id);
    }

    public Mensaje save(Mensaje message) {
        return crud3.save(message);
    }

    public void delete(Mensaje message) {
        crud3.delete(message);
    }
}
