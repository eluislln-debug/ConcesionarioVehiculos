/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.util.*;
import java.io.*;
import modelo.*;

public class ControladorUsuario {

    private static final String RUTA_CSV = "data/usuarios.csv";

    // ✅ Leer todos los usuarios desde el CSV
    public static List<Usuario> cargarUsuarios() {
        List<Usuario> usuarios = new ArrayList<>();

        File archivo = new File(RUTA_CSV);
        if (!archivo.exists()) {
            System.out.println("⚠️ Archivo de usuarios no encontrado, se creará uno nuevo.");
            return usuarios;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(RUTA_CSV))) {
            String linea;
            br.readLine(); // saltar encabezado

            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");

                if (datos.length < 5) continue;

                String id = datos[0];
                String nombre = datos[1];
                String usuario = datos[2];
                String contrasena = datos[3];
                String rol = datos[4];

                Usuario u;
                if (rol.equalsIgnoreCase("Administrador")) {
                    u = new Administrador(id, nombre, usuario, contrasena);
                } else {
                    u = new Cliente(id, nombre, usuario, contrasena);
                }

                usuarios.add(u);
            }
        } catch (IOException e) {
            System.out.println("❌ Error al leer usuarios: " + e.getMessage());
        }

        return usuarios;
    }

    // ✅ Guardar todos los usuarios en el CSV
    public static void guardarUsuarios(List<Usuario> usuarios) {
        try (FileWriter fw = new FileWriter(RUTA_CSV)) {
            fw.write("ID,Nombre,Usuario,Contrasena,Rol\n");

            for (Usuario u : usuarios) {
                fw.write(String.join(",",
                        u.getId(),
                        u.getNombre(),
                        u.getUsuario(),
                        u.getContrasena(),
                        u.getRol()
                ));
                fw.write("\n");
            }

            System.out.println("✅ Usuarios guardados correctamente.");
        } catch (IOException e) {
            System.out.println("❌ Error al guardar usuarios: " + e.getMessage());
        }
    }

    // ✅ Validar inicio de sesión
    public static Usuario validarLogin(String usuario, String contrasena) {
        for (Usuario u : cargarUsuarios()) {
            if (u.getUsuario().equals(usuario) && u.getContrasena().equals(contrasena)) {
                return u; // retorna el usuario autenticado
            }
        }
        return null; // no encontrado
    }

    // ✅ Registrar un nuevo usuario
    public static void registrarUsuario(Usuario nuevo) {
        List<Usuario> usuarios = cargarUsuarios();
        usuarios.add(nuevo);
        guardarUsuarios(usuarios);
    }
}
