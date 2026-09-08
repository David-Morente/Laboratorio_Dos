public class Visitante {
    private String codigoEntrada;
    private String nombre;
    private int edad;
    private int atraccionesVisitadas;
    private int puntosAcumulados;

    public Visitante(String codigoEntrada, String nombre, int edad,
                     int atraccionesVisitadas, int puntosAcumulados) {
        validarDatos(edad, atraccionesVisitadas, puntosAcumulados);
        this.codigoEntrada = codigoEntrada;
        this.nombre = nombre;
        this.edad = edad;
        this.atraccionesVisitadas = atraccionesVisitadas;
        this.puntosAcumulados = puntosAcumulados;
    }

    private void validarDatos(int edad, int atracciones, int puntos) {
        if (edad <= 0) {
            throw new IllegalArgumentException("La edad debe ser mayor que 0.");
        }
        if (atracciones < 0) {
            throw new IllegalArgumentException("Las atracciones no pueden ser negativas.");
        }
        if (puntos < 0) {
            throw new IllegalArgumentException("Los puntos no pueden ser negativos.");
        }
    }

    public void modificarInformacion(String nombre, int edad,
                                     int atracciones, int puntos) {
        validarDatos(edad, atracciones, puntos);
        this.nombre = nombre;
        this.edad = edad;
        this.atraccionesVisitadas = atracciones;
        this.puntosAcumulados = puntos;
    }

    public String getCodigoEntrada() { return codigoEntrada; }
    public String getNombre() { return nombre; }
    public int getEdad() { return edad; }
    public int getAtraccionesVisitadas() { return atraccionesVisitadas; }
    public int getPuntosAcumulados() { return puntosAcumulados; }

    @Override
    public String toString() {
        return "Codigo: " + codigoEntrada + ", nombre: " + nombre
                + ", edad: " + edad + ", atracciones: "
                + atraccionesVisitadas + ", puntos: " + puntosAcumulados;
    }
}
