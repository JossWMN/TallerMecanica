package Paquete;

public class Auto extends Vehiculo {
    private float anchura;
    private float altura;

    public Auto(String matricula, String marca, String modelo, int anio, float cilindrada, Cliente propietario, float anchura, float altura) {
        super(matricula, marca, modelo, anio, cilindrada, propietario,"Auto");
        this.anchura = anchura;
        this.altura = altura;
    }

    public float getAltura() {
        return altura;
    }

    public float getAnchura() {
        return anchura;
    }

    @Override
    public String identificacion(String matricula) {
        return matricula;
    }
}