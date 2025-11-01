/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import modelo.*;

public class PruebaUsuarios {
    public static void main(String[] args) {
        Usuario u = ControladorUsuario.validarLogin("admin", "1234");

        if (u != null) {
            System.out.println("Bienvenido, " + u.getNombre() + " - Rol: " + u.getRol());
        } else {
            System.out.println(" Usuario o contraseña incorrectos.");
        }
    }
}
