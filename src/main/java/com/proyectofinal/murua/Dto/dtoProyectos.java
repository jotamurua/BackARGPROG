/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyectofinal.murua.Dto;

import javax.validation.constraints.NotBlank;

/**
 *
 * @author Joel
 */

public class dtoProyectos {
    @NotBlank
        private String nombre;
    @NotBlank
    private String descripcion;
    private String linkdeploy;
    private String linkgithub;

    public dtoProyectos() {
    }

    public dtoProyectos(String nombre, String descripcion, String linkdeploy, String linkgithub) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.linkdeploy = linkdeploy;
        this.linkgithub = linkgithub;
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
