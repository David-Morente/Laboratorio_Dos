public class PuntoAcceso {
    private String codigo;
    private String nombre;
    private String ubicacion;
    private int capacidadMaximaPorHora;
    private String estado;

    public PuntoAcceso(String codigo, String nombre, String ubicacion,
                       int capacidadMaximaPorHora, String estado) {
        if (capacidadMaximaPorHora <= 0) {
            throw new IllegalArgumentException("La capacidad debe ser mayor que 0.");
        }
        this.codigo = codigo;
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.capacidadMaximaPorHora = capacidadMaximaPorHora;
        this.estado = estado;
    }

    public void modificarCapacidad(int capacidad) {
        if (capacidad <= 0) {
            throw new IllegalArgumentException("La capacidad debe ser mayor que 0.");
        }
        capacidadMaximaPorHora = capacidad;
    }

    public void modificarEstado(String estado) {
        this.estado = estado;
    }

    public int getCapacidadMaximaPorHora() {
        return capacidadMaximaPorHora;
    }

    @Override
    public String toString() {
        return "Codigo: " + codigo + ", nombre: " + nombre
                + ", ubicacion: " + ubicacion + ", capacidad: "
                + capacidadMaximaPorHora + ", estado: " + estado;
    }
}
