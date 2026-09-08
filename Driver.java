import java.util.InputMismatchException;
import java.util.Scanner;

public class Driver {
    private static Scanner scanner = new Scanner(System.in);
    private static Parque parque;

    public static void main(String[] args) {
        System.out.println("SISTEMA DEL PARQUE UNIVERSITARIO");
        crearParque();
        mostrarMenu();
        scanner.close();
    }

    public static void mostrarMenu() {
        int opcion = 0;
        while (opcion != 13) {
            imprimirOpciones();
            try {
                System.out.print("Seleccione una opcion: ");
                opcion = scanner.nextInt();
                scanner.nextLine();
                ejecutarOpcion(opcion);
            } catch (InputMismatchException e) {
                System.out.println("Error: debe ingresar un numero entero.");
                scanner.nextLine();
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            } finally {
                System.out.println("Operacion finalizada.\n");
            }
        }
    }

    private static void imprimirOpciones() {
        System.out.println("1. Nuevo parque");
        System.out.println("2. Habilitar punto de acceso");
        System.out.println("3. Consultar puntos de acceso");
        System.out.println("4. Consultar un punto de acceso");
        System.out.println("5. Modificar punto de acceso");
        System.out.println("6. Cerrar punto de acceso");
        System.out.println("7. Registrar visitante");
        System.out.println("8. Consultar visitantes");
        System.out.println("9. Buscar visitante");
        System.out.println("10. Modificar visitante");
        System.out.println("11. Eliminar visitante");
        System.out.println("12. Mostrar reporte del parque");
        System.out.println("13. Salir");
    }

    private static void ejecutarOpcion(int opcion) {
        if (opcion == 1) {
            crearParque();
        } else if (opcion == 2) {
            habilitarPunto();
        } else if (opcion == 3) {
            parque.consultarPuntosAcceso();
        } else if (opcion == 4) {
            System.out.print("Posicion (0-4): ");
            parque.consultarPuntoAcceso(scanner.nextInt());
            scanner.nextLine();
        } else if (opcion == 5) {
            modificarPunto();
        } else if (opcion == 6) {
            System.out.print("Posicion (0-4): ");
            parque.cerrarPuntoAcceso(scanner.nextInt());
            scanner.nextLine();
            System.out.println("Punto de acceso cerrado.");
        } else if (opcion == 7) {
            registrarVisitante();
        } else if (opcion == 8) {
            parque.consultarVisitantes();
        } else if (opcion == 9) {
            buscarVisitante();
        } else if (opcion == 10) {
            modificarVisitante();
        } else if (opcion == 11) {
            eliminarVisitante();
        } else if (opcion == 12) {
            parque.generarReporte();
        } else if (opcion == 13) {
            System.out.println("Programa terminado.");
        } else {
            System.out.println("Opcion no valida.");
        }
    }

    private static void crearParque() {
        System.out.print("Nombre del parque: ");
        String nombre = scanner.nextLine();
        System.out.print("Codigo: ");
        String codigo = scanner.nextLine();
        System.out.print("Encargado: ");
        String encargado = scanner.nextLine();
        parque = new Parque(nombre, codigo, encargado);
        System.out.println("Parque creado correctamente.\n");
    }

    private static void habilitarPunto() {
        System.out.print("Posicion (0-4): ");
        int posicion = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Codigo: ");
        String codigo = scanner.nextLine();
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Ubicacion: ");
        String ubicacion = scanner.nextLine();
        System.out.print("Capacidad maxima por hora: ");
        int capacidad = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Estado: ");
        String estado = scanner.nextLine();
        parque.habilitarPuntoAcceso(posicion,
                new PuntoAcceso(codigo, nombre, ubicacion, capacidad, estado));
        System.out.println("Punto de acceso habilitado.");
    }

    private static void modificarPunto() {
        System.out.print("Posicion (0-4): ");
        int posicion = scanner.nextInt();
        System.out.print("Nueva capacidad: ");
        int capacidad = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Nuevo estado: ");
        String estado = scanner.nextLine();
        parque.modificarPuntoAcceso(posicion, capacidad, estado);
        System.out.println("Punto de acceso modificado.");
    }

    private static Visitante pedirDatosVisitante(String codigo) {
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Edad: ");
        int edad = scanner.nextInt();
        System.out.print("Atracciones visitadas: ");
        int atracciones = scanner.nextInt();
        System.out.print("Puntos acumulados: ");
        int puntos = scanner.nextInt();
        scanner.nextLine();
        return new Visitante(codigo, nombre, edad, atracciones, puntos);
    }

    private static void registrarVisitante() {
        System.out.print("Codigo de entrada: ");
        String codigo = scanner.nextLine();
        parque.registrarVisitante(pedirDatosVisitante(codigo));
        System.out.println("Visitante registrado.");
    }

    private static void buscarVisitante() {
        System.out.print("Codigo de entrada: ");
        Visitante visitante = parque.buscarVisitante(scanner.nextLine());
        System.out.println(visitante == null ? "Visitante no encontrado." : visitante);
    }

    private static void modificarVisitante() {
        System.out.print("Codigo de entrada: ");
        String codigo = scanner.nextLine();
        Visitante datos = pedirDatosVisitante(codigo);
        parque.modificarVisitante(codigo, datos.getNombre(), datos.getEdad(),
                datos.getAtraccionesVisitadas(), datos.getPuntosAcumulados());
        System.out.println("Visitante modificado.");
    }

    private static void eliminarVisitante() {
        System.out.print("Codigo de entrada: ");
        parque.eliminarVisitante(scanner.nextLine());
        System.out.println("Visitante eliminado.");
    }
}