package Paquete;

public class GestionTaller {
    private TrabajoTaller[] trabajos;
    private int contadorTrabajos;
    private  int capacidad ;
    public GestionTaller(int capacidad) {
        this.capacidad = capacidad;
        this.trabajos = new TrabajoTaller[capacidad];
        this.contadorTrabajos = 0;
    }
    public boolean agregarTrabajo(TrabajoTaller trabajo) {
        if (contadorTrabajos < capacidad) {
            trabajos[contadorTrabajos] = trabajo;
            contadorTrabajos++;
            return true; // Trabajo agregado exitosamente
        }
        return false; // Taller lleno
    }
    public TrabajoTaller[] obtenerTrabajosRecibidos() {
        int count = 0;
        for (int i = 0; i < contadorTrabajos; i++) {
            if (trabajos[i].getEstatus().equals("Recibido")) {
                count++;
            }
        }
        TrabajoTaller[] recibidos = new TrabajoTaller[count];
        int cont = 0;
        for (int i = 0; i < contadorTrabajos; i++) {
            if (trabajos[i].getEstatus().equals("Recibido")) {
                recibidos[cont] = trabajos[i];
                cont++;
            }
        }
        return recibidos;
    }

    public TrabajoTaller[] obtenerTrabajosTerminados() {
        int count = 0;
        for (int i = 0; i < contadorTrabajos; i++) {
            if (trabajos[i].getEstatus().equals("Terminado")) {
                count++;
            }
        }
        TrabajoTaller[] terminados = new TrabajoTaller[count];
        int cont = 0;
        for (int i = 0; i < contadorTrabajos; i++) {
            if (trabajos[i].getEstatus().equals("Terminado")) {
                terminados[cont] = trabajos[i];
                cont++;
            }
        }
        return terminados;
    }

    public TrabajoTaller[] obtenerTrabajosPorPropietario(String cedula) {
        int count = 0;
        for (int i = 0; i < contadorTrabajos; i++) {
            String cedulaCliente = trabajos[i].getVehiculo().getPropietario().getCedula();
            if (cedulaCliente != null && cedulaCliente.equalsIgnoreCase(cedula)) {
                count++;
            }
        }

        TrabajoTaller[] resultado = new TrabajoTaller[count];
        int cont = 0;
        for (int i = 0; i < contadorTrabajos; i++) {
            String cedulaCliente = trabajos[i].getVehiculo().getPropietario().getCedula();
            if (cedulaCliente != null && cedulaCliente.equalsIgnoreCase(cedula)) {
                resultado[cont++] = trabajos[i];
            }
        }
        return resultado;
    }


    public float porcentajeMantenimientoPorTipo(boolean esAuto) {
        int totalVehiculos = 0;
        int mantenimientoCount = 0;
        for (int i = 0; i < contadorTrabajos; i++) {
            Vehiculo v = trabajos[i].getVehiculo();
            boolean esDelTipo = (esAuto && v.getTipo().equals("Auto")) || (!esAuto && v.getTipo().equals("Moto"));
            if (esDelTipo) {
                totalVehiculos++;
                if (trabajos[i].getMotivo().equalsIgnoreCase("mantenimiento")) {
                    mantenimientoCount++;
                }
            }
        }
        if (totalVehiculos == 0) return 0;
        return (float) mantenimientoCount * 100 / totalVehiculos;
    }

    public float porcentajeReparacionPorTipo(boolean esAuto) {
        int totalVehiculos = 0;
        int reparacionCount = 0;
        for (int i = 0; i < contadorTrabajos; i++) {
            Vehiculo v = trabajos[i].getVehiculo();
            boolean esDelTipo = (esAuto && v.getTipo().equals("Auto")) || (!esAuto && v.getTipo().equals("Moto"));
            if (esDelTipo) {
                totalVehiculos++;
                if (trabajos[i].getMotivo().equalsIgnoreCase("reparacion")) {
                    reparacionCount++;
                }
            }
        }
        if (totalVehiculos == 0) return 0;
        return (float) reparacionCount * 100 / totalVehiculos;
    }
}

