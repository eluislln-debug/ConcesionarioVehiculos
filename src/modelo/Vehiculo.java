/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author f
 */
public class Vehiculo {

    private String marca;
    private String modelo;
    private int anio;
    private double precio;
    private String descripcion;
    private double kilometraje;
    private Propietario propietario;

    public Vehiculo() {
    }

    public Vehiculo(String marca, String modelo, int anio, double precio, String descripcion, double kilometraje, Propietario propietario) {
        this.marca = marca;
        this.modelo = modelo;
        this.anio = anio;
        this.precio = precio;
        this.descripcion = descripcion;
        this.kilometraje = kilometraje;
        this.propietario = propietario;
    }

    public String getMarca() { return marca; }
    public void setMarca(String marca) { this.marca = marca; }

    public String getModelo() { return modelo; }
    public void setModelo(String modelo) { this.modelo = modelo; }

    public int getAnio() { return anio; }
    public void setAnio(int anio) { this.anio = anio; }

    public double getPrecio() { return precio; }
    public void setPrecio(double precio) { this.precio = precio; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public double getKilometraje() { return kilometraje; }
    public void setKilometraje(double kilometraje) { this.kilometraje = kilometraje; }

    public Propietario getPropietario() { return propietario; }
    public void setPropietario(Propietario propietario) { this.propietario = propietario; }

    @Override
    public String toString() {
        return marca + " " + modelo + " (" + anio + ") - $" + precio;
    }
}
