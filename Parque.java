import java.util.ArrayList;

public class Parque {
    private String nombre;
    private String codigo;
    private String encargado;
    private PuntoAcceso[] puntosAcceso;
    private ArrayList<Visitante> visitantes;

    public Parque(String nombre, String codigo, String encargado) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.encargado = encargado;
        puntosAcceso = new PuntoAcceso[5];
        visitantes = new ArrayList<Visitante>();
    }

    private void validarPosicion(int posicion) {
        if (posicion < 0 || posicion >= puntosAcceso.length) {
            throw new IllegalArgumentException("La posicion debe estar entre 0 y 4.");
        }
    }

    public void habilitarPuntoAcceso(int posicion, PuntoAcceso punto) {
        validarPosicion(posicion);
        if (puntosAcceso[posicion] != null) {
            throw new IllegalArgumentException("La posicion ya esta ocupada.");
        }
        puntosAcceso[posicion] = punto;
    }

    public void consultarPuntosAcceso() {
        boolean hayPuntos = false;
        for (int i = 0; i < puntosAcceso.length; i++) {
            if (puntosAcceso[i] != null) {
                System.out.println("Posicion " + i + ": " + puntosAcceso[i]);
                hayPuntos = true;
            }
        }
        if (!hayPuntos) System.out.println("No hay puntos de acceso habilitados.");
    }

    public void consultarPuntoAcceso(int posicion) {
        validarPosicion(posicion);
        if (puntosAcceso[posicion] == null) {
            System.out.println("La posicion esta vacia.");
        } else {
            System.out.println(puntosAcceso[posicion]);
        }
    }

    public void modificarPuntoAcceso(int posicion, int capacidad, String estado) {
        validarPosicion(posicion);
        if (puntosAcceso[posicion] == null) {
            throw new IllegalArgumentException("No existe un punto en esa posicion.");
        }
        puntosAcceso[posicion].modificarCapacidad(capacidad);
        puntosAcceso[posicion].modificarEstado(estado);
    }

    public void cerrarPuntoAcceso(int posicion) {
        validarPosicion(posicion);
        if (puntosAcceso[posicion] == null) {
            throw new IllegalArgumentException("No existe un punto en esa posicion.");
        }
        puntosAcceso[posicion] = null;
    }

    public void registrarVisitante(Visitante visitante) {
        if (buscarVisitante(visitante.getCodigoEntrada()) != null) {
            throw new IllegalArgumentException("El codigo de entrada ya existe.");
        }
        visitantes.add(visitante);
    }

    public void consultarVisitantes() {
        if (visitantes.isEmpty()) {
            System.out.println("No hay visitantes registrados.");
            return;
        }
        for (Visitante visitante : visitantes) visitante.mostrarInformacion();
    }

    public Visitante buscarVisitante(String codigoEntrada) {
        for (int i = 0; i < visitantes.size(); i++) {
            if (visitantes.get(i).getCodigoEntrada().equalsIgnoreCase(codigoEntrada)) {
                return visitantes.get(i);
            }
        }
        return null;
    }

    public void modificarVisitante(String codigoEntrada, String nombre, int edad,
                                   int atracciones, int puntos) {
        Visitante visitante = buscarVisitante(codigoEntrada);
        if (visitante == null) throw new IllegalArgumentException("Visitante no encontrado.");
        visitante.modificarInformacion(nombre, edad, atracciones, puntos);
    }

    public void eliminarVisitante(String codigoEntrada) {
        for (int i = 0; i < visitantes.size(); i++) {
            if (visitantes.get(i).getCodigoEntrada().equalsIgnoreCase(codigoEntrada)) {
                visitantes.remove(i);
                return;
            }
        }
        throw new IllegalArgumentException("Visitante no encontrado.");
    }

    public void generarReporte() {
        int habilitados = 0;
        PuntoAcceso mayorCapacidad = null;
        for (PuntoAcceso punto : puntosAcceso) {
            if (punto != null) {
                habilitados++;
                if (mayorCapacidad == null || punto.getCapacidadMaximaPorHora()
                        > mayorCapacidad.getCapacidadMaximaPorHora()) mayorCapacidad = punto;
            }
        }
        System.out.println("\nREPORTE DE " + nombre + " (" + codigo + ")");
        System.out.println("Encargado: " + encargado);
        System.out.println("Puntos habilitados: " + habilitados);
        System.out.println("Espacios disponibles: " + (puntosAcceso.length - habilitados));
        System.out.println("Punto con mayor capacidad: "
                + (mayorCapacidad == null ? "No hay puntos habilitados" : mayorCapacidad));
        System.out.println("Visitantes registrados: " + visitantes.size());

        if (visitantes.isEmpty()) {
            System.out.println("No hay visitantes para realizar los demas calculos.");
            return;
        }

        Visitante mayorPuntos = visitantes.get(0);
        Visitante mayorAtracciones = visitantes.get(0);
        int sumaEdades = 0;
        for (Visitante visitante : visitantes) {
            sumaEdades += visitante.getEdad();
            if (visitante.getPuntosAcumulados() > mayorPuntos.getPuntosAcumulados())
                mayorPuntos = visitante;
            if (visitante.getAtraccionesVisitadas() > mayorAtracciones.getAtraccionesVisitadas())
                mayorAtracciones = visitante;
        }
        System.out.println("Visitante con mas puntos:");
        mayorPuntos.mostrarInformacion();
        System.out.println("Visitante con mas atracciones:");
        mayorAtracciones.mostrarInformacion();
        System.out.printf("Promedio de edad: ", (double) sumaEdades / visitantes.size());
    }
}
