package com.reto3.reto3.interfaces;

import com.reto3.reto3.tablas.Cliente;
import org.springframework.data.repository.CrudRepository;


public interface interfaceCliente extends CrudRepository <Cliente, Integer>{
    
}
