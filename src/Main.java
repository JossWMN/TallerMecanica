import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import Paquete.*;

public class Main {
    public static void main(String[] args) {
        GestionTaller gestionTaller = new GestionTaller(100); // Capacidad ejemplo
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            while (true) {
                System.out.println("\n         Menú Taller      ");
                System.out.println("1. Agregar trabajo (auto o moto)");
                System.out.println("2. Detalle de autos y motos recibidos");
                System.out.println("3. Detalle de autos y motos terminados");
                System.out.println("4. Listado de autos o motos por propietario (cédula)");
                System.out.println("5. Listado de autos o motos por marca");
                System.out.println("6. Porcentaje vehículos para mantenimiento (auto/moto)");
                System.out.println("7. Porcentaje vehículos para reparación extraordinaria (auto/moto)");
                System.out.println("8. Salir");
                System.out.print("Seleccione una opción: ");

                String opcion = br.readLine().trim();

                switch (opcion) {
                    case "1":
                        agregarTrabajoInteractivo(gestionTaller, br);
                        break;
                    case "2":
                        mostrarTrabajos(gestionTaller.obtenerTrabajosRecibidos());
                        break;
                    case "3":
                        mostrarTrabajos(gestionTaller.obtenerTrabajosTerminados());
                        break;
                    case "4":
                        System.out.print("Ingrese la cédula del propietario: ");
                        String cedula = br.readLine().trim();
                        if (cedula.isEmpty()) {
                            System.out.println("La cédula no puede estar vacía.");
                            break;
                        }
                        TrabajoTaller[] trabajosPorCedula = buscarTrabajoPorCedula(gestionTaller, cedula);

                        if (trabajosPorCedula.length == 0) {
                            System.out.println("No se encontraron trabajos para la cédula ingresada.");
                        } else {
                            mostrarTrabajos(trabajosPorCedula);
                        }
                        break;
                    case "5":
                        System.out.print("Ingrese la marca del vehículo (Ej: Toyota): ");
                        String marca = br.readLine().trim().toLowerCase();
                        if (marca.isEmpty()) {
                            System.out.println("La marca no puede estar vacía.");
                            break;
                        }
                        TrabajoTaller[] trabajosPorMarca = buscarTrabajosPorMarca(gestionTaller, marca);
                        if (trabajosPorMarca.length == 0) {
                            System.out.println("No se encontraron trabajos para la marca ingresada.");
                        } else {
                            mostrarTrabajos(trabajosPorMarca);
                        }
                        break;
                    case "6":
                        mostrarPorcentaje(gestionTaller, br, "mantenimiento");
                        break;
                    case "7":
                        mostrarPorcentaje(gestionTaller, br, "reparacion");
                        break;
                    case "8":
                        System.out.println("Saliendo del programa...");
                        return;
                    default:
                        System.out.println("Opción no válida. Intente de nuevo.");
                }
            }

        } catch (IOException e) {
            System.out.println("Error leyendo entrada: " + e.getMessage());
        }
    }

    // Método para agregar trabajos
    private static void agregarTrabajoInteractivo(GestionTaller gestionTaller, BufferedReader br) throws IOException {
        System.out.println("\n--- Agregar trabajo ---");

        // Datos cliente
        System.out.print("Nombre cliente: ");
        String nombre = br.readLine().trim();
        System.out.print("Apellido cliente: ");
        String apellido = br.readLine().trim();
        System.out.print("Dirección cliente: ");
        String direccion = br.readLine().trim();
        System.out.print("Cédula cliente: ");
        String cedula = br.readLine().trim();
        System.out.print("Teléfono cliente: ");
        String telefono = br.readLine().trim();
        System.out.print("Correo cliente: ");
        String correo = br.readLine().trim();
        Cliente cliente = new Cliente(nombre, apellido, direccion, cedula, telefono, correo);

        // Datos vehículo
        System.out.print("Tipo vehículo (auto/moto): ");
        String tipoVeh = br.readLine().trim().toLowerCase();
        while (!tipoVeh.equals("auto") && !tipoVeh.equals("moto")) {
            System.out.println("Tipo inválido. Ingrese 'auto' o 'moto'.");
            tipoVeh = br.readLine().trim().toLowerCase();
        }

        System.out.print("Matrícula: ");
        String matricula = br.readLine().trim();
        System.out.print("Marca: ");
        String marca = br.readLine().trim();
        System.out.print("Modelo: ");
        String modelo = br.readLine().trim();

        int anio = 0;
        while (true) {
            System.out.print("Año: ");
            String anioStr = br.readLine().trim();
            try {
                anio = Integer.parseInt(anioStr);
                if (anio < 1900 || anio > 2025) {
                    System.out.println("Año inválido. Intente de nuevo.");
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Debe ingresar un número válido para el año.");
            }
        }

        float cilindrada = 0;
        while (true) {
            System.out.print("Cilindrada (ej: 1.6): ");
            String cilStr = br.readLine().trim();
            try {
                cilindrada = Float.parseFloat(cilStr);
                if (cilindrada <= 0) {
                    System.out.println("Cilindrada debe ser mayor que cero.");
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Debe ingresar un número válido para cilindrada.");
            }
        }

        Vehiculo vehiculo;
        if (tipoVeh.equals("auto")) {
            // Para auto, solicita datos extra
            float largo = 0, ancho = 0;
            while (true) {
                System.out.print("Largo del auto (m): ");
                String largoStr = br.readLine().trim();
                try {
                    largo = Float.parseFloat(largoStr);
                    if (largo <= 0) {
                        System.out.println("Largo debe ser mayor que cero.");
                    } else {
                        break;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Ingrese un número válido para largo.");
                }
            }
            while (true) {
                System.out.print("Ancho del auto (m): ");
                String anchoStr = br.readLine().trim();
                try {
                    ancho = Float.parseFloat(anchoStr);
                    if (ancho <= 0) {
                        System.out.println("Ancho debe ser mayor que cero.");
                    } else {
                        break;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Ingrese un número válido para ancho.");
                }
            }
            vehiculo = new Auto(matricula, marca, modelo, anio, cilindrada, cliente, largo, ancho);
        } else {
            // Para moto, solicita limitador
            System.out.print("¿Tiene limitador? (s/n): ");
            String resp = br.readLine().trim().toLowerCase();
            while (!resp.equals("s") && !resp.equals("n")) {
                System.out.println("Ingrese 's' para sí o 'n' para no.");
                resp = br.readLine().trim().toLowerCase();
            }
            boolean tieneLimitador = resp.equals("s");
            vehiculo = new Moto(matricula, marca, modelo, anio, cilindrada, cliente, tieneLimitador);
        }

        // Datos trabajo
        System.out.print("Fecha ingreso (yyyy-mm-dd): ");
        String fecha = br.readLine().trim();

        System.out.print("Motivo (mantenimiento/reparacion): ");
        String motivo = br.readLine().trim().toLowerCase();
        while (!motivo.equals("mantenimiento") && !motivo.equals("reparacion")) {
            System.out.println("Motivo inválido. Ingrese 'mantenimiento' o 'reparacion'.");
            motivo = br.readLine().trim().toLowerCase();
        }

        System.out.print("Asesor: ");
        String asesor = br.readLine().trim();

        // Crear trabajo y agregar
        TrabajoTaller trabajo = new TrabajoTaller(fecha, motivo, matricula, asesor, vehiculo);
        if (gestionTaller.agregarTrabajo(trabajo)) {
            System.out.println("Trabajo agregado correctamente.");
        } else {
            System.out.println("No se pudo agregar el trabajo (capacidad llena).");
        }
    }

    // Método para mostrar lista de trabajos
    private static void mostrarTrabajos(TrabajoTaller[] trabajos) {
        if (trabajos.length == 0) {
            System.out.println("No hay trabajos para mostrar.");
            return;
        }
        System.out.println("\n   Detalle de Trabajos  ");
        for (TrabajoTaller t : trabajos) {
            Vehiculo v = t.getVehiculo();
            Cliente c = v.getPropietario();
            System.out.println("Matrícula: " + v.getMatricula() +
                    ", Tipo: " + v.getTipo() +
                    ", Marca: " + v.getMarca() +
                    ", Modelo: " + v.getModelo() +
                    ", Año: " + v.getAnio() +
                    ", Propietario: " + c.getNombre() + " " + c.getApellido() +
                    ", Cédula: " + c.getCedula() +
                    ", Motivo: " + t.getMotivo() +
                    ", Estatus: " + t.getEstatus() +
                    ", Costo: $" + t.getCostoTra());
        }
    }

    private static TrabajoTaller[] buscarTrabajoPorCedula(GestionTaller gestionTaller, String cedula) {
        TrabajoTaller[] recibidos = gestionTaller.obtenerTrabajosRecibidos();
        TrabajoTaller[] terminados = gestionTaller.obtenerTrabajosTerminados();
        TrabajoTaller[] combinados = new TrabajoTaller[recibidos.length + terminados.length];

        System.arraycopy(recibidos, 0, combinados, 0, recibidos.length);
        System.arraycopy(terminados, 0, combinados, recibidos.length, terminados.length);

        int count = 0;
        TrabajoTaller[] encontrados = new TrabajoTaller[combinados.length];

        for (int i = 0; i < combinados.length; i++) {
            Vehiculo v = combinados[i].getVehiculo();

            if (v.getPropietario().getCedula().equalsIgnoreCase(cedula)) {
                encontrados[count++] = combinados[i];
            }
        }

        TrabajoTaller[] resultado = new TrabajoTaller[count];
        System.arraycopy(encontrados, 0, resultado, 0, count);
        return resultado;
    }

    // Buscar trabajos por marca
    private static TrabajoTaller[] buscarTrabajosPorMarca(GestionTaller gestionTaller, String marcaBuscada) {
        TrabajoTaller[] recibidos = gestionTaller.obtenerTrabajosRecibidos();
        TrabajoTaller[] terminados = gestionTaller.obtenerTrabajosTerminados();

        TrabajoTaller[] combinados = new TrabajoTaller[recibidos.length + terminados.length];
        System.arraycopy(recibidos, 0, combinados, 0, recibidos.length);
        System.arraycopy(terminados, 0, combinados, recibidos.length, terminados.length);

        int count = 0;
        TrabajoTaller[] encontrados = new TrabajoTaller[combinados.length];
        for (int i = 0; i < combinados.length; i++) {
            Vehiculo v = combinados[i].getVehiculo();
            if (v.getMarca().toLowerCase().equals(marcaBuscada)) {
                encontrados[count++] = combinados[i];
            }
        }
        TrabajoTaller[] resultado = new TrabajoTaller[count];
        System.arraycopy(encontrados, 0, resultado, 0, count);
        return resultado;
    }

    // Mostrar porcentaje de vehículos para mantenimiento o reparación, filtrando por tipo (auto o moto)
    private static void mostrarPorcentaje(GestionTaller gestionTaller, BufferedReader br, String tipoTrabajo) throws IOException {
        System.out.print("¿Desea ver porcentaje para Auto o Moto? (A/M): ");
        String tipo = br.readLine().trim().toUpperCase();
        if (!tipo.equals("A") && !tipo.equals("M")) {
            System.out.println("Opción inválida. Debe ingresar 'A' para Auto o 'M' para Moto.");
            return;
        }
        boolean esAuto = tipo.equals("A");
        float porcentaje = 0;
        if (tipoTrabajo.equals("mantenimiento")) {
            porcentaje = gestionTaller.porcentajeMantenimientoPorTipo(esAuto);
        } else if (tipoTrabajo.equals("reparacion")) {
            porcentaje = gestionTaller.porcentajeReparacionPorTipo(esAuto);
        }
        System.out.printf("Porcentaje de vehículos para %s (%s): %.2f%%\n",
                tipoTrabajo,
                esAuto ? "Auto" : "Moto",
                porcentaje);
    }
}