/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Asus
 */
public class CitaDao {
    
    private final String RUTA_ARCHIVO = "src/data/solicitudes.csv"; 

  
    public List<Cita> cargarCitas() {
        List<Cita> listaCitas = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(RUTA_ARCHIVO))) { 
            String linea;
            
            while ((linea = br.readLine()) != null) {
         
                String[] datos = linea.split(",");
                
               
                if (datos.length == 5) { 
                    Cita nuevaCita = new Cita(
                        datos[0].trim(), // Nombre
                        datos[1].trim(), // Teléfono
                        datos[2].trim(), // Correo
                        datos[3].trim(), // Fecha
                        datos[4].trim()  // Descripción (Para)
                    );
                    listaCitas.add(nuevaCita);
                }
            }
        } catch (IOException e) {
           
            System.err.println("Advertencia: El archivo de citas aún no existe en " + RUTA_ARCHIVO + " o no se pudo acceder. Mensaje: " + e.getMessage());
        }
        return listaCitas;
    }
    
  
}
    
