/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyectofinal.murua.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
/**
 *
 * @author Joel
 */
@Entity
public class Proyectos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre;
    private String descripcion;
    private String linkdeploy;
    private String linkgithub;

    public Proyectos() {
    }

    public Proyectos(String nombre, String descripcion, String linkdeploy, String linkgithub) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.linkdeploy = linkdeploy;
        this.linkgithub = linkgithub;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getLinkdeploy() {
        return linkdeploy;
    }

    public void setLinkdeploy(String linkdeploy) {
        this.linkdeploy = linkdeploy;
    }

    public String getLinkgithub() {
        return linkgithub;
    }

    public void setLinkgithub(String linkgithub) {
        this.linkgithub = linkgithub;
    }
    
    
}
