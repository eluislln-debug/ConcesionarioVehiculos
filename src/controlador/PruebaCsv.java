/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import modelo.*;
import util.*;
import java.util.ArrayList;
/**
 *
 * @author f
 */
public class PruebaCsv {
    public static void main(String[] args) {
        String ruta = "data/vehiculos.csv";
        ArrayList<Vehiculo> lista = LectorCSV.cargarVehiculos(ruta);

        // Mostrar los vehículos actuales
        for (Vehiculo v : lista) {
            System.out.println(v);
        }

        // Agregar un vehículo nuevo de prueba
        Propietario nuevoProp = new Propietario("33333333", "Carlos Ruiz", "310999888", "Calle 50 #10");
        Vehiculo nuevo = new Vehiculo("Chevrolet", "Sail", 2019, 45000, "Buen estado", 30000, nuevoProp);
        lista.add(nuevo);

        // Guardar la lista actualizada
        CsvUtil.guardarVehiculos(ruta, lista);
    }
}
