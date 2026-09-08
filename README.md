# Análisis (grupo 4, lab 2)

## ¿Qué propiedades y métodos tendrá cada clase?

### Parque

**Atributos:**

- nombre
- codigo
- encargado
- puntosAcceso
- visitantes

**Métodos:**

- habilitarPuntoAcceso()
- consultarPuntosAcceso()
- consultarPuntoAcceso()
- modificarPuntoAcceso()
- cerrarPuntoAcceso()
- registrarVisitante()
- consultarVisitantes()
- buscarVisitante()
- modificarVisitante()
- eliminarVisitante()
- generarReporte()

### PuntoAcceso

**Atributos:**

- codigo
- nombre
- ubicacion
- capacidadMaximaPorHora
- estado

**Métodos:**

- modificarCapacidad()
- modificarEstado()

### Visitante

**Atributos:**

- codigoEntrada
- nombre
- edad
- atraccionesVisitadas
- puntosAcumulados

**Métodos:**

- modificarInformacion()

### Driver

**Atributos:**

- scanner
- parque

**Métodos:**

- main()
- mostrarMenu()

## ¿Qué tipo deben tener las propiedades y métodos de cada clase?

| Clase | Atributo | Tipo |
|---|---|---|
| Parque | nombre | String |
| Parque | codigo | String |
| Parque | encargado | String |
| Parque | puntosAcceso | PuntoAcceso[] |
| Parque | visitantes | ArrayList |
| PuntoAcceso | codigo | String |
| PuntoAcceso | nombre | String |
| PuntoAcceso | ubicacion | String |
| PuntoAcceso | capacidadMaximaPorHora | intPapa |
| PuntoAcceso | estado | String |
| Visitante | codigoEntrada | String |
| Visitante | nombre | String |
| Visitante | edad | int |
| Visitante | atraccionesVisitadas | int |
| Visitante | puntosAcumulados | int |

## ¿Cuál de las propiedades identificadas debe implementarse utilizando un arreglo básico? ¿Qué tipo de objetos almacenará y cuál será su tamaño?

La propiedad `puntosAcceso` será un arreglo básico de objetos `PuntoAcceso` con 5 posiciones.

## ¿Cuál de las propiedades identificadas debe implementarse utilizando un ArrayList? ¿Qué tipo de objetos almacenará?

La propiedad `visitantes` será un `ArrayList` que almacenará objetos de tipo `Visitante`.

## ¿Cuáles deben ser los modificadores de visibilidad de los miembros en cada clase?

Los atributos serán `private`.

Los métodos que deban utilizarse desde otras clases serán `public`.

## ¿Qué parámetros serán requeridos por los métodos en sus clases?

```java
habilitarPuntoAcceso(int posicion, PuntoAcceso punto)

consultarPuntoAcceso(int posicion)

modificarPuntoAcceso(int posicion, int capacidad, String estado)

cerrarPuntoAcceso(int posicion)

registrarVisitante(Visitante visitante)

buscarVisitante(String codigoEntrada)

modificarVisitante(
    String codigoEntrada,
    String nombre,
    int edad,
    int atraccionesVisitadas,
    int puntosAcumulados
)

eliminarVisitante(String codigoEntrada)
```

## ¿Cómo proveerá de valores iniciales a sus objetos? ¿Qué valores deberán validarse antes de modificar el estado de los objetos?

Los objetos recibirán sus valores mediante constructores.

Se validará:

- Capacidad máxima por hora mayor que 0.
- Edad mayor que 0.
- Atracciones visitadas mayor o igual que 0.
- Puntos acumulados mayor o igual que 0.
- Posiciones del arreglo dentro del rango 0-4.
- Posiciones del arreglo disponibles antes de agregar un punto.
- Códigos de visitante no repetidos.

Los valores inválidos producirán `IllegalArgumentException`.

## ¿Cómo determinará si una posición del arreglo contiene un punto de acceso o contiene null?

Se utilizará la siguiente condición para determinar si una posición está vacía:

```java
if (puntosAcceso[posicion] == null)
```

## ¿Cómo realizará las operaciones de búsqueda, modificación y eliminación dentro del ArrayList?

Se recorrerá el `ArrayList` utilizando un ciclo `for`.

- **Búsqueda:** comparar el código de entrada.
- **Modificación:** localizar al visitante y cambiar sus datos.
- **Eliminación:** localizar al visitante y utilizar `remove()`.

## ¿Qué situaciones del programa pueden producir excepciones?

### InputMismatchException

Se produce cuando se ingresa un tipo de dato incorrecto mediante `Scanner`.

### IllegalArgumentException

Se produce cuando se introducen valores que no cumplen las reglas establecidas.

### Manejo de excepciones

- `try-catch`: se utilizará para manejar las entradas y valores incorrectos.
- `finally`: se utilizará para ejecutar una acción final independientemente de si ocurre una excepción.

<img width="1042" height="874" alt="WhatsApp Image 2026-09-07 at 10 48 17 PM" src="https://github.com/user-attachments/assets/c87b4544-5580-4ca5-a9fd-9594462a3e2a" />
