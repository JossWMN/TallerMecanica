package Paquete;

public class Moto extends Vehiculo {
    private boolean tieneLimitador;

    public Moto(String matricula, String marca, String modelo, int anio, float cilindrada, Cliente propietario, boolean tieneLimitador) {
        super(matricula, marca, modelo, anio, cilindrada, propietario,"Moto");
        this.tieneLimitador = tieneLimitador;
    }
    public boolean getTieneLimitador() {
        return tieneLimitador;
    }
    @Override
    public String identificacion(String matricula) {
        return matricula;
    }
}