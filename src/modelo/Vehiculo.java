/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

public class Vehiculo {

    private String id;
    private String marca;
    private String modelo;
    private String caracteristicas;
    private double precio;
    private int anio;
    private String descripcion;
    private String imagenes;
    private String videos;
    private String propietario;
    private double kilometraje;

    // 🔹 Constructor vacío
    public Vehiculo() {}

    // 🔹 Constructor con todos los atributos
    public Vehiculo(String id, String marca, String modelo, String caracteristicas,
                    double precio, int anio, String descripcion,
                    String imagenes, String videos, String propietario, double kilometraje) {
        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
        this.caracteristicas = caracteristicas;
        this.precio = precio;
        this.anio = anio;
        this.descripcion = descripcion;
        this.imagenes = imagenes;
        this.videos = videos;
        this.propietario = propietario;
        this.kilometraje = kilometraje;
    }

    // 🔹 Getters y setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getMarca() { return marca; }
    public void setMarca(String marca) { this.marca = marca; }

    public String getModelo() { return modelo; }
    public void setModelo(String modelo) { this.modelo = modelo; }

    public String getCaracteristicas() { return caracteristicas; }
    public void setCaracteristicas(String caracteristicas) { this.caracteristicas = caracteristicas; }

    public double getPrecio() { return precio; }
    public void setPrecio(double precio) { this.precio = precio; }

    public int getAnio() { return anio; }
    public void setAnio(int anio) { this.anio = anio; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public String getImagenes() { return imagenes; }
    public void setImagenes(String imagenes) { this.imagenes = imagenes; }

    public String getVideos() { return videos; }
    public void setVideos(String videos) { this.videos = videos; }

    public String getPropietario() { return propietario; }
    public void setPropietario(String propietario) { this.propietario = propietario; }

    public double getKilometraje() { return kilometraje; }
    public void setKilometraje(double kilometraje) { this.kilometraje = kilometraje; }

    // 🔹 Convertir a CSV
    public String toCSV() {
        return String.join(",", id, marca, modelo, caracteristicas,
                String.valueOf(precio), String.valueOf(anio), descripcion,
                imagenes, videos, propietario, String.valueOf(kilometraje));
    }

    @Override
    public String toString() {
        return marca + " " + modelo + " (" + anio + ") - $" + precio;
    }
}
