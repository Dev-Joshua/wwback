package com.woofwk.woofworkout.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "usuarios")
public class Usuario {
    @Id
    private Long id_usuario;
    private String nombre;
    private String apellidos;
    private String documento_identidad;
    private String direccion;
    private String celular;
    private String email;
    private String contrasena;

    @Enumerated(EnumType.STRING)
    private Role rol;

    private Long mascota_id;
    
    

    public enum Role {
        CLIENTE, ENTRENADOR, PASEADOR, CUIDADOR
    }

    public Long getId() {
        return id_usuario;
    }
    public void setId(Long id) {
        this.id_usuario = id;
    }
    public Role getRol() {
        return rol;
    }
    public void setRol(Role rol) {
        this.rol = rol;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellidos() {
        return apellidos;
    }
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
    public String getDocumento_identidad() {
        return documento_identidad;
    }
    public void setDocumento_identidad(String documento_identidad) {
        this.documento_identidad = documento_identidad;
    }
    public String getDireccion() {
        return direccion;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public String getCelular() {
        return celular;
    }
    public void setCelular(String celular) {
        this.celular = celular;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getContrasena() {
        return contrasena;
    }
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
    public Long getMascota_id() {
        return mascota_id;
    }
    public void setMascota_id(Long mascota_id) {
        this.mascota_id = mascota_id;
    }
 
}
