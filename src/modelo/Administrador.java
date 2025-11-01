/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author f
 */
public class Administrador extends Usuario {
    public Administrador() {
        super();
        this.rol = "Administrador";
    }

    public Administrador(String id, String nombre, String usuario, String contrasena) {
        super(id, nombre, usuario, contrasena, "Administrador");
    }

    // Métodos específicos del administrador (luego implementaremos lógica)
    public void registrarVehiculo() {
        System.out.println("Registrar vehículo (lógica por implementar)");
    }

    public void eliminarVehiculo() {
        System.out.println("Eliminar vehículo (lógica por implementar)");
    }

    public void actualizarVehiculo() {
        System.out.println("Actualizar vehículo (lógica por implementar)");
    }
}
