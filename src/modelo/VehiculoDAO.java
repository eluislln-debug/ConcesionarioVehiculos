/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class VehiculoDAO {

    // Ruta del archivo CSV dentro de tu proyecto (puede estar en build o en la raíz)
    private String rutaArchivo = "src/data/vehiculos.csv";

    public List<Vehiculo> cargarVehiculos() {
        List<Vehiculo> lista = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(getClass().getResourceAsStream("/data/vehiculos.csv")))) {

            String linea;
            boolean primeraLinea = true;
            while ((linea = br.readLine()) != null) {
                if (primeraLinea) { primeraLinea = false; continue; }

                String[] datos = linea.split(",");
                if (datos.length == 11) {
                    try {
                        Vehiculo v = new Vehiculo(
                            datos[0], datos[1], datos[2], datos[3],
                            Double.parseDouble(datos[4]),
                            Integer.parseInt(datos[5]),
                            datos[6], datos[7], datos[8], datos[9],
                            Double.parseDouble(datos[10])
                        );
                        lista.add(v);
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null,
                            "Error de formato en línea: " + linea,
                            "Error", JOptionPane.WARNING_MESSAGE);
                    }
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                "Error al leer el archivo de vehículos: " + e.getMessage(),
                "Error", JOptionPane.ERROR_MESSAGE);
        }

        return lista;
    }



    public void guardarVehiculos(List<Vehiculo> lista) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(rutaArchivo))) {
            // Escribir encabezado
            bw.write("id,marca,modelo,caracteristicas,precio,anio,descripcion,imagenes,videos,propietario,kilometraje");
            bw.newLine();

            for (Vehiculo v : lista) {
                bw.write(v.toCSV());
                bw.newLine();
            }

            JOptionPane.showMessageDialog(null,
                "Los vehículos se guardaron correctamente.",
                "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null,
                "Error al guardar los vehículos: " + e.getMessage(),
                "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

}

