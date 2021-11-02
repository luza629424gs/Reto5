package com.reto3.reto3.contraladores;

import com.reto3.reto3.servicios.serviciosOrtopedic;
import com.reto3.reto3.tablas.Ortopedic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Ortopedic")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})

public class controladorOrtopedic {
    @Autowired
    private serviciosOrtopedic controladorOrtopedic;

    @GetMapping("/all")
    public List<Ortopedic> getOrtopedics() {
        return controladorOrtopedic.getAll();
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Ortopedic save(@RequestBody Ortopedic ortopedic) {
        return controladorOrtopedic.save(ortopedic);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Ortopedic update(@RequestBody Ortopedic ortopedic) {
        return controladorOrtopedic.update(ortopedic);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int ortopedicId) {
        return controladorOrtopedic.deleteOrtopedic(ortopedicId);
    }

}
