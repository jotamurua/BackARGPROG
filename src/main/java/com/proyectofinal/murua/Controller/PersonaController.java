/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyectofinal.murua.Controller;

import com.proyectofinal.murua.Entity.Experiencia;
import com.proyectofinal.murua.Entity.Persona;
import com.proyectofinal.murua.Interface.IPersonaService;
import com.proyectofinal.murua.Security.Controller.Mensaje;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Joel
 */
@RestController
@CrossOrigin(origins = "https://frontendargprog-8b1ad.web.app")
public class PersonaController {

    @Autowired
    IPersonaService ipersonaService;
    
    @GetMapping("/personas/traer")
    public List<Persona> getPersona() {
        return ipersonaService.getPersona();
    }
  
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/personas/crear")
    public String createPersona(@RequestBody Persona persona){
    ipersonaService.savePersona(persona);
    return "Se creo correctamente.";
    }

    @PreAuthorize("hasRole('ADMIN')")    
    @DeleteMapping("/personas/borrar/{id}")
    public String deletePersona(@PathVariable Long id){
        ipersonaService.deletePersona(id);
        return "la persona fue eliminada correctamente";
    }

    @PreAuthorize("hasRole('ADMIN')")    
    @PutMapping("/personas/editar/{id}")
    public Persona editPersona(@PathVariable Long id,
                                @RequestParam("nombre") String nuevoNombre,
                                @RequestParam("apellido") String nuevoApellido,
                                @RequestParam("img") String nuevoImg,
                                @RequestParam("banner") String nuevoBanner,
                                @RequestParam("titulo") String nuevoTitulo,
                                @RequestParam("ubicacion") String nuevoUbicacion,
                                @RequestParam("acercade") String nuevoAcercaDe){
        Persona persona = ipersonaService.findPersona(id);
        persona.setNombre(nuevoNombre);
        persona.setApellido(nuevoApellido);
        persona.setImg(nuevoImg);
        persona.setBanner(nuevoBanner);
        persona.setTitulo(nuevoTitulo);
        persona.setUbicacion(nuevoUbicacion);
        persona.setAcercade(nuevoAcercaDe);
        
        ipersonaService.savePersona(persona);
        
        return persona;
    }
    
        @GetMapping("/personas/traer/perfil")
    public Persona findPersona(){
        return ipersonaService.findPersona((long)1);
    }
}
