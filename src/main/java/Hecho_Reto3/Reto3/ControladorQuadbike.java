/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hecho_Reto3.Reto3;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author KirverM
 */
@RestController
@RequestMapping("/api/Quadbike")
@CrossOrigin(origins ="*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class ControladorQuadbike {
    
     @Autowired
    private ServiciosQuadbike servicio;

    @GetMapping("/all")
    public List<Quadbike> getQuadbike() {
        return servicio.getAll();
    }
    
     @GetMapping("/{id}")
    public Optional<Quadbike> getQuadbike(@PathVariable("id") int quadbikeId){
    return servicio.getQuadbike(quadbikeId);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Quadbike save(@RequestBody Quadbike quadbike) {
        return servicio.save(quadbike);
    }
    
     @DeleteMapping("/{id}")
     @ResponseStatus(HttpStatus.NO_CONTENT)
    public Boolean delete(@PathVariable("id") int quadbikeId) {
        return servicio.deletequadbike(quadbikeId);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Quadbike update(@RequestBody Quadbike quadbike) {
        return servicio.update(quadbike);
    }
    
}
