package com.reto3.reto3.servicios;

import com.reto3.reto3.repositorio.repositorioCategoria;
import com.reto3.reto3.tablas.Categoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class serviciosCategoria {
    @Autowired
    private repositorioCategoria categoriaServicios;

    public List<Categoria> getAll(){
        return categoriaServicios.getAll();
    }
    public Optional<Categoria> getCategoria(int categoriaId) {
        return categoriaServicios.getCategoria(categoriaId);
    }
    public Categoria save(Categoria categoria) {
        if (categoria.getId() == null) {
            return categoriaServicios.save(categoria);
        } else {
            Optional<Categoria> category = categoriaServicios.getCategoria(categoria.getId());
            if (category.isEmpty()) {
                return categoriaServicios.save(categoria);
            } else {
                return categoria;
            }
        }
    }

    public Categoria update(Categoria categoria){
        if(categoria.getId()!=null){
            Optional<Categoria>cambiar=categoriaServicios.getCategoria(categoria.getId());
            if(!cambiar.isEmpty()){
                if(categoria.getDescription()!=null){
                    cambiar.get().setDescription(categoria.getDescription());
                }
                if(categoria.getName()!=null){
                    cambiar.get().setName(categoria.getName());
                }
                return categoriaServicios.save(cambiar.get());
            }
        }
        return categoria;
    }
    public boolean deletecategory(int categoriaId) {
        Boolean eliminar = getCategoria(categoriaId).map(category -> {
            categoriaServicios.delete(category);
            return true;
        }).orElse(false);
        return eliminar;
    }



}
