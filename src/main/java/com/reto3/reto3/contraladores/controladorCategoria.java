package com.reto3.reto3.contraladores;

import com.reto3.reto3.servicios.serviciosCategoria;
import com.reto3.reto3.tablas.Categoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Category")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class controladorCategoria {
    @Autowired
    private serviciosCategoria categoriaControl;

    @GetMapping("/all")
    public List<Categoria> getCategoria(){
        return categoriaControl.getAll();
    }
    // Tener cuidado
    @GetMapping("/{id}")
    public Optional<Categoria> getCategory(@PathVariable("id") int categoriaId) {
        return categoriaControl.getCategoria(categoriaId);
    }
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Categoria save(@RequestBody Categoria categoria) {
        return categoriaControl.save(categoria);
    }
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Categoria update(@RequestBody Categoria categoria) {
        return categoriaControl.update(categoria);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int categoriaId) {
        return categoriaControl.deletecategory(categoriaId);
    }
}
