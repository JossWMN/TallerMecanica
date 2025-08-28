package Paquete;

public class TrabajoTaller {
    private String fechaing;
    private String motivo ;
    private String matricula;
    private String asesor;
    private String estatus;
    private float costoTra;
    private Vehiculo vehiculo;

    public TrabajoTaller(String fechaing, String motivo, String matricula, String asesor, Vehiculo vehiculo) {
        this.fechaing = fechaing;
        this.motivo = motivo;
        this.matricula = matricula;
        this.asesor = asesor;
        this.estatus = "Recibido"; //Para mantenerlo por defecto
        this.costoTra = 0;
        this.vehiculo = vehiculo;
    }

    public String getFechaing() {
        return fechaing;
    }
    public void setFechaing(String fechaing) {
        this.fechaing = fechaing;
    }
    public String getMotivo() {
        return motivo;
    }
    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }
    public String getMatricula() {
        return matricula;
    }
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
    public String getAsesor() {
        return asesor;
    }
    public void setAsesor(String asesor) {
        this.asesor = asesor;
    }
    public String getEstatus() {
        return estatus;
    }
    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }
    public float getCostoTra() {
      return costoTra;
    }
    public void setCostoTra(float costo) {
        if (costo > 0){    //Evitara que se ingresen numeros negativos
            this.costoTra = costo;
        }
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }
    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    //Metodo en caso de inicio del trabajo
    public void iniciarTrabajo(){
        if (this.estatus.equals("Recibido")){
            setEstatus("En proceso");
        }
    }
    //Metodo de finalizacion del trabjo
    public void finalizarTrabajo(){
        if (this.estatus.equals("En Proceso" )){
            setCostoTra(costoTra);
            setEstatus("Terminado");
        }
    }
}
