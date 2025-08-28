package Paquete;

public class Cliente {
    private String nombre;
    private String apellido;
    private String direccion;
    private String cedula;
    private String telefono;
    private String correo;
    public Cliente(String nombre, String apellido, String direccion, String cedula, String telefono, String correo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.cedula = cedula;
        this.telefono = telefono;
        this.correo = correo;
    }
    public String getNombre() {
        return nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public String getDireccion() {
        return direccion;
    }
    public String getCedula() {
        return cedula;
    }
    public String getTelefono() {
        return telefono;
    }
    public String getCorreo() {
        return correo;
    }


}
