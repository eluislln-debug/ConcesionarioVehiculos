/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import modelo.Vehiculo;
import modelo.Propietario;
import util.CsvUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ControladorVehiculo {

    private static final String RUTA_CSV = "data/vehiculos.csv";

    // Guardar lista de vehículos en el CSV
    public void guardarVehiculos(List<Vehiculo> lista) {
        List<String[]> datos = new ArrayList<>();

        // Opcional: escribir encabezado si lo deseas
        // datos.add(new String[]{"Marca","Modelo","Anio","Precio","Descripcion","Kilometraje","CedulaPropietario","NombrePropietario","TelefonoPropietario","DireccionPropietario"});

        for (Vehiculo v : lista) {
            String cedula = (v.getPropietario() != null) ? v.getPropietario().getCedula() : "";
            String nombreProp = (v.getPropietario() != null) ? v.getPropietario().getNombreCompleto() : "";
            String tel = (v.getPropietario() != null) ? v.getPropietario().getTelefono() : "";
            String dir = (v.getPropietario() != null) ? v.getPropietario().getDireccion() : "";

            datos.add(new String[]{
                    v.getMarca(),
                    v.getModelo(),
                    String.valueOf(v.getAnio()),
                    String.valueOf(v.getPrecio()),
                    v.getDescripcion(),
                    String.valueOf(v.getKilometraje()),
                    cedula,
                    nombreProp,
                    tel,
                    dir
            });
        }

        CsvUtil.escribirCSV(RUTA_CSV, datos);
        System.out.println("Vehículos guardados en CSV.");
    }

    // Leer vehículos desde el CSV
    public List<Vehiculo> cargarVehiculos(Map<String, Propietario> propietarios) {
        List<Vehiculo> lista = new ArrayList<>();
        List<String[]> datos = CsvUtil.leerCSV(RUTA_CSV);

        for (String[] fila : datos) {
            if (fila.length < 7) continue; // Evitar errores

            // Ajusta índices según si usas encabezado o no
            try {
                Propietario p = propietarios.get(fila[6]);
                Vehiculo v = new Vehiculo(
                        fila[0], // marca
                        fila[1], // modelo
                        Integer.parseInt(fila[2]), // anio
                        Double.parseDouble(fila[3]), // precio
                        fila[4], // descripcion
                        Double.parseDouble(fila[5]), // kilometraje
                        p
                );
                lista.add(v);
            } catch (NumberFormatException e) {
                System.out.println("Fila con formato inválido en CSV, se omite: " + String.join(",", fila));
            }
        }
        System.out.println("Vehículos cargados desde CSV.");
        return lista;
    }
}
