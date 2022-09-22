/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyectofinal.murua.Controller;

import com.proyectofinal.murua.Dto.dtoProyectos;
import com.proyectofinal.murua.Entity.Proyectos;
import com.proyectofinal.murua.Security.Controller.Mensaje;
import com.proyectofinal.murua.Service.SProyectos;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Joel
 */
@RestController
@CrossOrigin(origins = "https://frontendargprog-8b1ad.web.app")
@RequestMapping("/proyectos")
public class CProyectos {

    @Autowired
    SProyectos sProyectos;

    @GetMapping("/lista")
    public ResponseEntity<List<Proyectos>> list() {
        List<Proyectos> list = sProyectos.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Proyectos> getById(@PathVariable("id")int id){
        if(!sProyectos.existsById(id)){
            return new ResponseEntity(new Mensaje("Esa id no existe"), HttpStatus.NOT_FOUND);
            
        }
        
        Proyectos proyectos = sProyectos.getOne(id).get();
        
        return new ResponseEntity(proyectos, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!sProyectos.existsById(id)) {
            return new ResponseEntity(new Mensaje("Esa id no existe"), HttpStatus.NOT_FOUND);
        }
        sProyectos.delete(id);
        return new ResponseEntity(new Mensaje("Proyecto eliminado"), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoProyectos dtoproyectos) {
        if (StringUtils.isBlank(dtoproyectos.getNombre())) {
            return new ResponseEntity(new Mensaje("Campo nombre obligatorio"), HttpStatus.BAD_REQUEST);
        }
        Proyectos proyectos = new Proyectos(
                dtoproyectos.getNombre(), dtoproyectos.getDescripcion(), dtoproyectos.getLinkdeploy(), dtoproyectos.getLinkgithub());
        sProyectos.save(proyectos);

        return new ResponseEntity(new Mensaje("Proyecto creado"), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoProyectos dtoproyectos) {
        if (!sProyectos.existsById(id)) {
            return new ResponseEntity(new Mensaje("No existe ese id"), HttpStatus.NOT_FOUND);
        }
        if (StringUtils.isBlank(dtoproyectos.getNombre())) {
            return new ResponseEntity(new Mensaje("Nombre obligatorio"), HttpStatus.BAD_REQUEST);
        }

        Proyectos proyectos = sProyectos.getOne(id).get();
        proyectos.setNombre(dtoproyectos.getNombre());
        proyectos.setDescripcion(dtoproyectos.getDescripcion());
        proyectos.setLinkdeploy(dtoproyectos.getLinkdeploy());
        proyectos.setLinkgithub(dtoproyectos.getLinkgithub());
        
        sProyectos.save(proyectos);
        
        return new ResponseEntity(new Mensaje("Proyecto actualizado"), HttpStatus.OK);
    }
}
