/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author f
 */
public class Usuario {
    protected String id;
    protected String nombre;
    protected String usuario;
    protected String contrasena;
    protected String rol; // Puede ser "Administrador" o "Cliente"

    public Usuario() {
    }

    public Usuario(String id, String nombre, String usuario, String contrasena, String rol) {
        this.id = id;
        this.nombre = nombre;
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.rol = rol;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getUsuario() { return usuario; }
    public void setUsuario(String usuario) { this.usuario = usuario; }

    public String getContrasena() { return contrasena; }
    public void setContrasena(String contrasena) { this.contrasena = contrasena; }

    public String getRol() { return rol; }
    public void setRol(String rol) { this.rol = rol; }

    @Override
    public String toString() {
        return nombre + " (" + rol + ")";
    }
}
