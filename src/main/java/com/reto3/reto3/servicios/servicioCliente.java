package com.reto3.reto3.servicios;

import com.reto3.reto3.repositorio.repositorioCliente;
import com.reto3.reto3.tablas.Cliente;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class servicioCliente {
    
    @Autowired
    private repositorioCliente crudCliente;
    
    public List<Cliente> getAll() {
        return crudCliente.getAll();
    }

    public Optional<Cliente> getCliente(int clientId) {
        return crudCliente.getCliente(clientId);
    }

    public Cliente save(Cliente cliente) {
        if (cliente.getIdClient() == null) {
            return crudCliente.save(cliente);
        } else {
            Optional<Cliente> e = crudCliente.getCliente(cliente.getIdClient());
            if (e.isEmpty()) {
                return crudCliente.save(cliente);
            } else {
                return cliente;
            }
        }
    }
    
    public Cliente update(Cliente cliente) {
        if (cliente.getIdClient() != null) {
            Optional<Cliente> e = crudCliente.getCliente(cliente.getIdClient());
            if (!e.isEmpty()) {
                if (cliente.getName() != null) {
                    e.get().setName(cliente.getName());
                }
                if (cliente.getAge() != null) {
                    e.get().setAge(cliente.getAge());
                }
                if (cliente.getPassword() != null) {
                    e.get().setPassword(cliente.getPassword());
                }
                crudCliente.save(e.get());
                return e.get();
            } else {
                return cliente;
            }
        } else {
            return cliente;
        }
    }
    
    public boolean deleteClient(int clientId) {
        Boolean aBoolean = getCliente(clientId).map(cliente -> {
            crudCliente.delete(cliente);
            return true;
        }).orElse(false);
        return aBoolean;
    }

}
