/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author f
 */
public class Cliente extends Usuario{
    public Cliente() {
        super();
        this.rol = "Cliente";
    }

    public Cliente(String id, String nombre, String usuario, String contrasena) {
        super(id, nombre, usuario, contrasena, "Cliente");
    }

    // Métodos específicos del cliente
    public void revisarCatalogo() {
        System.out.println("Revisar catálogo (lógica por implementar)");
    }

    public void solicitarCita() {
        System.out.println("Solicitar cita (lógica por implementar)");
    }
}
