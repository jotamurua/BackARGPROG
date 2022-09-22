/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyectofinal.murua.Controller;

import com.proyectofinal.murua.Dto.dtoPerfil;
import com.proyectofinal.murua.Entity.Perfil;
import com.proyectofinal.murua.Security.Controller.Mensaje;
import com.proyectofinal.murua.Service.SPerfil;
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
@RequestMapping("/perfil")
@RestController
@CrossOrigin(origins = "https://frontendargprog-8b1ad.web.app")
public class CPerfil {

    @Autowired
    SPerfil sPerfil;

    @GetMapping("/lista")
    public ResponseEntity<List<Perfil>> list() {
        List<Perfil> list = sPerfil.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Perfil> getById(@PathVariable("id") int id) {
        if (!sPerfil.existsById(id)) {
            return new ResponseEntity(new Mensaje("No existe ID"), HttpStatus.BAD_REQUEST);
        }
        Perfil perfil = sPerfil.getOne(id).get();
        return new ResponseEntity(perfil, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!sPerfil.existsById(id)) {
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);

        }
        sPerfil.delete(id);
        return new ResponseEntity(new Mensaje("Perfil eliminado"), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoPerfil dtoperfil) {
        if (StringUtils.isBlank(dtoperfil.getNombre())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(dtoperfil.getApellido())) {
            return new ResponseEntity(new Mensaje("El Apellido es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(dtoperfil.getTitulo())) {
            return new ResponseEntity(new Mensaje("El Titulo es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(dtoperfil.getUbicacion())) {
            return new ResponseEntity(new Mensaje("La ubicacion es obligatoria"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(dtoperfil.getAcercade())) {
            return new ResponseEntity(new Mensaje("La seccion Acerca de es obligatoria"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(dtoperfil.getImg())) {
            return new ResponseEntity(new Mensaje("La foto de perfil es obligatoria"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(dtoperfil.getBanner())) {
            return new ResponseEntity(new Mensaje("El Banner es obligatorio"), HttpStatus.BAD_REQUEST);
        }

        Perfil perfil = new Perfil(
                dtoperfil.getNombre(), dtoperfil.getApellido(), dtoperfil.getTitulo(), dtoperfil.getUbicacion(), dtoperfil.getAcercade(), dtoperfil.getImg(), dtoperfil.getBanner()
        );
        sPerfil.save(perfil);
        return new ResponseEntity(new Mensaje("Perfil Creado"), HttpStatus.OK);
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoPerfil dtoperfil) {
        if (!sPerfil.existsById(id)) {
            return new ResponseEntity(new Mensaje("No existe el id"), HttpStatus.NOT_FOUND);
        }
        Perfil perfil = sPerfil.getOne(id).get();
        perfil.setNombre(dtoperfil.getNombre());
        perfil.setApellido(dtoperfil.getApellido());
        perfil.setTitulo(dtoperfil.getTitulo());
        perfil.setUbicacion(dtoperfil.getUbicacion());
        perfil.setAcercade(dtoperfil.getAcercade());
        perfil.setImg(dtoperfil.getImg());
        perfil.setBanner(dtoperfil.getBanner());
        sPerfil.save(perfil);

        return new ResponseEntity(new Mensaje("Perfil Actualizado"), HttpStatus.OK);
    }
}
