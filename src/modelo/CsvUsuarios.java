/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CsvUsuarios {

    public static String validarUsuario(String usuario, String contrasena) {
        String ruta = "data/usuarios.csv";

        try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
            String linea;

            while ((linea = br.readLine()) != null) {
                // Separa los datos del CSV por comas
                String[] datos = linea.split(",");

                // Asegurarse de que la línea tenga al menos 5 columnas
                if (datos.length < 5) continue;

                String idCsv = datos[0].trim();
                String nombreCsv = datos[1].trim();
                String usuarioCsv = datos[2].trim();
                String contrasenaCsv = datos[3].trim();
                String rolCsv = datos[4].trim();

                // Validar usuario y contraseña
                if (usuarioCsv.equals(usuario) && contrasenaCsv.equals(contrasena)) {
                    return rolCsv; // Retorna "Administrador" o "Cliente"
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null; // No se encontró el usuario
    }

    public static void guardarUsuario(String id, String nombre, String usuario, String contrasena, String rol) {
        String ruta = "data/usuarios.csv";

        try (java.io.FileWriter fw = new java.io.FileWriter(ruta, true);
             java.io.BufferedWriter bw = new java.io.BufferedWriter(fw);
             java.io.PrintWriter pw = new java.io.PrintWriter(bw)) {

            pw.println(id + "," + nombre + "," + usuario + "," + contrasena + "," + rol);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}