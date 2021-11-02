/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.reto3.reto3.repositorio;

import com.reto3.reto3.interfaces.interfaceCliente;
import com.reto3.reto3.tablas.Cliente;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class repositorioCliente {
    
    @Autowired
    private interfaceCliente crudCliente;
    
    public List<Cliente> getAll() {
    return (List<Cliente>) crudCliente.findAll();
    }
    
    public Optional<Cliente> getCliente(int id) {
        return crudCliente.findById(id);
    }
    
    public Cliente save(Cliente cliente) {
        return crudCliente.save(cliente);
    }

    public void delete(Cliente cliente) {
        crudCliente.delete(cliente);
    }

}
