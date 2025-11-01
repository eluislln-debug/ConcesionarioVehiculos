/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import modelo.Propietario;
import modelo.Vehiculo;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
/**
 *
 * @author f
 */
public class LectorCSV {
    public static ArrayList<Vehiculo> cargarVehiculos(String rutaArchivo) {
        ArrayList<Vehiculo> vehiculos = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            br.readLine(); // Saltar encabezado

            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");

                if (datos.length >= 10) {
                    Propietario propietario = new Propietario(
                            datos[6], datos[7], datos[8], datos[9]
                    );

                    Vehiculo vehiculo = new Vehiculo(
                            datos[0],                // marca
                            datos[1],                // modelo
                            Integer.parseInt(datos[2]), // año
                            Double.parseDouble(datos[3]), // precio
                            datos[4],                // descripcion
                            Double.parseDouble(datos[5]), // kilometraje
                            propietario
                    );

                    vehiculos.add(vehiculo);
                }
            }

        } catch (IOException e) {
            System.out.println("Error al leer el archivo CSV: " + e.getMessage());
        }

        return vehiculos;
    }
}
