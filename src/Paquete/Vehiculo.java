package Paquete;

public abstract class Vehiculo {
    private String matricula;
    private String marca;
    private String modelo;
    private int anio;
    private float cilindrada;
    private Cliente propietario;
    private String tipo; // Auto o Moto

    public Vehiculo(String matricula, String marca, String modelo, int anio, float cilindrada, Cliente propietario,  String tipo) {
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
        this.anio = anio;
        this.cilindrada = cilindrada;
        this.propietario = propietario;
        this.tipo = tipo;
    }

    public Cliente getPropietario() {
        return propietario;
    }

    public String getMarca() {
        return marca;
    }

    public String getMatricula() {
        return matricula;
    }

    public int getAnio() {
        return anio;
    }
    public double getCilindrada() {
        return cilindrada;
    }

    public String getModelo() {
        return modelo;
    }
    public Cliente getpropietario() {
        return propietario;
    }
    public String getTipo() {
        return tipo;
    }

    public abstract String identificacion(String matricula);
}