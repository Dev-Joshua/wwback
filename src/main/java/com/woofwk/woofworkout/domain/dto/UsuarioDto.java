package com.woofwk.woofworkout.domain.dto;

import com.woofwk.woofworkout.models.Usuario.Role;


public class UsuarioDto {
    private String nombre;
    private String apellidos;
    private String documento_identidad;
    private String direccion;
    private String celular;
    private String email;
    private String contrasena;
    private Role rol;

    
    
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
    public Role getRol() {
        return rol;
    }
    public void setRol(Role rol) {
        this.rol = rol;
    }
}
