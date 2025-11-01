/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.io.*;
import java.util.*;
import modelo.Vehiculo;

public class CsvUtil {

    // 🟢 Método genérico para escribir listas de datos (texto plano)
    public static void escribirCSV(String ruta, List<String[]> datos) {
        try (FileWriter writer = new FileWriter(ruta)) {
            for (String[] fila : datos) {
                writer.write(String.join(",", fila) + "\n");
            }
            System.out.println("✅ Archivo CSV guardado correctamente en: " + ruta);
        } catch (IOException e) {
            System.out.println("❌ Error al escribir el CSV: " + e.getMessage());
        }
    }

    // 🟣 Método genérico para leer datos desde un CSV
    public static List<String[]> leerCSV(String ruta) {
        List<String[]> datos = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] fila = linea.split(",");
                datos.add(fila);
            }
            System.out.println("✅ Archivo CSV leído correctamente: " + ruta);
        } catch (IOException e) {
            System.out.println("❌ Error al leer el CSV: " + e.getMessage());
        }

        return datos;
    }

    // 🟡 Método específico para guardar vehículos en el CSV
    public static void guardarVehiculos(String ruta, ArrayList<Vehiculo> lista) {
        try (FileWriter writer = new FileWriter(ruta)) {
            // Encabezado
            writer.write("Marca,Modelo,Anio,Precio,Descripcion,Kilometraje,CedulaPropietario,NombrePropietario,TelefonoPropietario,DireccionPropietario\n");
            
            // Filas
            for (Vehiculo v : lista) {
                writer.write(v.getMarca() + "," +
                             v.getModelo() + "," +
                             v.getAnio() + "," +
                             v.getPrecio() + "," +
                             v.getDescripcion() + "," +
                             v.getKilometraje() + "," +
                             v.getPropietario().getCedula() + "," +
                             v.getPropietario().getNombreCompleto() + "," +
                             v.getPropietario().getTelefono() + "," +
                             v.getPropietario().getDireccion() + "\n");
            }

            System.out.println("Vehiculos guardados correctamente en: " + ruta);
        } catch (IOException e) {
            System.out.println("Error al guardar vehículos: " + e.getMessage());
        }
   }
}
