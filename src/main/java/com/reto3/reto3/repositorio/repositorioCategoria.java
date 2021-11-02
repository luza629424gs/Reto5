package com.reto3.reto3.repositorio;

import com.reto3.reto3.interfaces.interfaceCategoria;
import com.reto3.reto3.tablas.Categoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class repositorioCategoria {
    @Autowired
    private interfaceCategoria crudCategoria;

    public List<Categoria> getAll(){
        return (List<Categoria>) crudCategoria.findAll();
    }

    public Optional<Categoria> getCategoria(int id){
        return crudCategoria.findById(id);

    }
    public Categoria save(Categoria categoria) {
        return crudCategoria.save(categoria);
    }
    public void delete(Categoria categoria) {
        crudCategoria.delete(categoria);
    }

}
