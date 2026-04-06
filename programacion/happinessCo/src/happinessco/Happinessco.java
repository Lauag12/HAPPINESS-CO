package happinessco;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Clase principal que administra el sistema de eventos mediante un menú en
 * consola.
 */
public class Happinessco {

    // Estructuras de datos principales
    private static final HashMap<String, Usuario> usuarios = new HashMap<>();
    private static final HashMap<Integer, Evento> eventos = new HashMap<>();
    private static final ArrayList<Favorito> favoritos = new ArrayList<>();

    // Contadores autogenerados
    private static int contadorEventos = 0;
    private static int contadorGalerias = 0;

    // Entrada de datos
    private static final Scanner teclado = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;
        do {
            System.out.println("\n--- MENÚ PRINCIPAL ---");
            System.out.println("1. Añadir un usuario");
            System.out.println("2. Eliminar un usuario");
            System.out.println("3. Añadir un evento");
            System.out.println("4. Eliminar un evento");
            System.out.println("5. Añadir una galería");
            System.out.println("6. Eliminar galería");
            System.out.println("7. Añadir favorito");
            System.out.println("8. Eliminar favorito");
            System.out.println("9. Salir");
            opcion = leerEntero("Escoge una opción: ");

            switch (opcion) {
                case 1:
                    agregarUsuario();
                    break;
                case 2:
                    eliminarUsuario();
                    break;
                case 3:
                    agregarEvento();
                    break;
                case 4:
                    eliminarEvento();
                    break;
                case 5:
                    agregarGaleria();
                    break;
                case 6:
                    eliminarGaleria();
                    break;
                case 7:
                    agregarFavorito();
                    break;
                case 8:
                    eliminarFavorito();
                    break;
                case 9:
                    System.out.println("Saliendo del sistema...");

                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
            }

        } while (opcion != 9);
    }

    private static int leerEntero(String mensaje) {
        while (true) {
            try {
                System.out.print(mensaje);
                int numero = teclado.nextInt();
                teclado.nextLine(); // Limpiamos el buffer tras el número
                return numero;
            } catch (Exception e) {
                System.out.println("Error: Por favor, ingrese un número entero válido.");
                teclado.nextLine(); // Limpiamos el buffer para descartar la letra/texto erróneo
            }
        }
    }

    /**
     * Leer una cadena de texto del usuario y que no este vacia.
     *
     * @param mensaje El mensaje a mostrar al usuario
     * @return La cadena ingresada .Trim()
     */
    private static String leerCadena(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            String entrada = teclado.nextLine().trim(); //trim elimina los espacios de los extremos

            if (entrada.length() > 0) {  // Si la longitud es mayor a 0, significa que tiene texto
                return entrada;
            }
            System.out.println("Error: Este campo no puede estar vacío."); // Si llegó aquí es porque mide 0 (está vacía)
        }
    }

    // ----------------- FUNCIONES DEL MENÚ ------------------------------------
    // ---------- FUNCIÓN 1: AÑADIR USUARIO ----------
    /**
     * Añade un nuevo usuario al sistema. Solicita nombre, email y contraseña.
     * Valida que el email no exista previamente.
     */
    private static void agregarUsuario() {
        System.out.println("\n--- AÑADIR USUARIO ---");

        // 1. Pedimos los datos usando tu función leerCadena
        String nombre = leerCadena("Nombre: ");
        String email = leerCadena("Email: ");
        String password = leerCadena("Contraseña: ");

        // 2. Intentamos SACAR al usuario del mapa
       Usuario usuario = usuarios.get(email);

        // 3. Lo más sencillo: ¿Es nulo? 
        if (usuario == null) {
            // Si es nulo, el email está libre -> Guardamos
            Usuario nuevo = new Usuario(nombre, email, password);
            usuarios.put(email, nuevo);
            System.out.println("Guardado correctamente.");
        } else {
            // Si NO es nulo, es porque ya existe alguien
            System.out.println("El usuario ya existe.");
        }
    }

    // ---------- FUNCIÓN 2: ELIMINAR USUARIO ----------
    private static void eliminarUsuario() {
        String email = leerCadena("Email del usuario a borrar: ");

        // Intentamos borrar directamente
        if (usuarios.remove(email) != null) {
            System.out.println("Usuario eliminado.");
        } else {
            System.out.println("No se encontró ese email.");
        }
    }

    // ---------- FUNCIÓN 3: AÑADIR EVENTO ----------
    /**
     * Añade un nuevo evento al sistema. El ID se genera automáticamente usando
     * el contador. Solicita fecha, título, ubicación y descripción.
     */
    private static void agregarEvento() {
        String respuesta;

        do {
            System.out.println("\n--- NUEVO EVENTO (ID: " + contadorEventos + ") ---");

            // 1. Pedimos los datos
            String fecha = leerCadena("Fecha: ");
            String titulo = leerCadena("Título: ");
            String ubicacion = leerCadena("Ubicación: ");
            String descripcion = leerCadena("Descripción: ");

            // 2. Creamos y guardamos (usando el contador actual)
            Evento nuevoEvento = new Evento(contadorEventos, fecha, titulo, ubicacion, descripcion);
            eventos.put(contadorEventos, nuevoEvento);

            System.out.println("✅ Evento '" + titulo + "' guardado con ID " + contadorEventos);

            // 3. Aumentamos el contador para el siguiente
            contadorEventos++;

            // 4. ¿Desea continuar?
            System.out.print("\n¿Quieres añadir otro evento? (s/n): ");
            respuesta = teclado.nextLine().trim().toLowerCase();

        } while (respuesta.equals("s"));

        System.out.println("Volviendo al menú principal...");
    }

    // ---------- FUNCIÓN 4: ELIMINAR EVENTO ----------
    /**
     * Elimina un evento del sistema por su ID. También elimina los favoritos
     * asociados a ese evento.
     */
    private static void eliminarEvento() {
        System.out.println("--- ELIMINAR EVENTO ---");

        // Verificamos si hay eventos registrados
        if (eventos.isEmpty()) {
            System.out.println("No hay eventos registrados.");
            return;
        }

        // Mostramos la lista de eventos actuales
        mostrarEventos();

        // Solicitamos el ID del evento a eliminar
        int id = leerEntero("Ingrese el ID del evento a eliminar: ");

        // Verificamos si el evento existe
        if (!eventos.containsKey(id)) {
            System.out.println("El evento no existe");
        } else {
            // El evento existe, lo eliminamos
            eventos.remove(id);

            // Eliminamos los favoritos asociados a este evento
            favoritos.removeIf(fav -> fav.getIdEvento() == (int) id);

            System.out.println("Evento eliminado correctamente");
        }
    }

    // ---------- FUNCIÓN 5: AÑADIR GALERÍA ----------
    /**
     * Añade una galería a un evento existente. El ID de la galería se genera
     * automáticamente.
     */
    private static void agregarGaleria() {
        System.out.println("--- AÑADIR GALERÍA ---");

        // Verificamos si hay eventos registrados
        if (eventos.isEmpty()) {
            System.out.println("No hay eventos registrados. Primero cree un evento.");
            return;
        }

        // Mostramos los eventos disponibles
        mostrarEventos();

        // Solicitamos el ID del evento donde añadir la galería
        int idEvento = leerEntero("Ingrese el ID del evento: ");

        // Verificamos si el evento existe
        // get(clave) retorna el valor asociado o null si no existe
        Evento evento = eventos.get(idEvento);

        if (evento == null) {
            System.out.println("El evento no existe");
            return;
        }

        // El evento existe, solicitamos datos de la galería
        String tituloGaleria = leerCadena("Ingrese el título de la galería: ");

        // Generamos el ID automáticamente
        int idGaleria = contadorGalerias++;

        // Creamos la nueva galería
        Galeria nuevaGaleria = new Galeria(idGaleria, tituloGaleria, idEvento);

        // Añadimos la galería al evento usando el método auxiliar
        evento.agregarGaleria(nuevaGaleria);

        System.out.println("Galería creada correctamente (ID: " + idGaleria + ")");
    }

    // ---------- FUNCIÓN 6: ELIMINAR GALERÍA ----------
    /**
     * Elimina una galería de un evento. Primero selecciona el evento, luego la
     * galería a eliminar.
     */
    private static void eliminarGaleria() {
        System.out.println("--- ELIMINAR GALERÍA ---");

        // Verificamos si hay eventos
        if (eventos.isEmpty()) {
            System.out.println("No hay eventos registrados.");
            return;
        }

        // Mostramos eventos
        mostrarEventos();

        // Solicitamos el ID del evento
        int idEvento = leerEntero("Ingrese el ID del evento: ");

        // Obtenemos el evento
        Evento evento = eventos.get(idEvento);

        if (evento == null) {
            System.out.println("El evento no existe");
            return;
        }

        // Verificamos si el evento tiene galerías
        if (evento.getGalerias().isEmpty()) {
            System.out.println("Este evento no tiene galerías.");
            return;
        }

        // Mostramos las galerías del evento
        mostrarGaleriasDeEvento(evento);

        // Solicitamos el ID de la galería a eliminar
        int idGaleria = leerEntero("Ingrese el ID de la galería a eliminar: ");

        // Intentamos eliminar la galería usando el método auxiliar del evento
        // eliminarGaleria() retorna true si tuvo éxito, false si no encontró la galería
        boolean eliminada = evento.eliminarGaleria(idGaleria);

        if (eliminada) {
            System.out.println("Galería eliminada correctamente");
        } else {
            System.out.println("La galería no existe");
        }
    }

    // ---------- FUNCIÓN 7: AÑADIR FAVORITO ----------
    /**
     * Añade un favorito (relación usuario-evento). Valida que tanto el usuario
     * como el evento existan.
     */
    private static void agregarFavorito() {
        System.out.println("--- AÑADIR FAVORITO ---");

        // Verificamos que existan usuarios y eventos
        if (usuarios.isEmpty()) {
            System.out.println("No hay usuarios registrados.");
            return;
        }

        if (eventos.isEmpty()) {
            System.out.println("No hay eventos registrados.");
            return;
        }

        // Mostramos usuarios y eventos disponibles
        mostrarUsuarios();
        System.out.println();  // Línea en blanco de separación
        mostrarEventos();

        // Solicitamos los datos del favorito
        String email = leerCadena("Ingrese el email del usuario: ");
        int idEvento = leerEntero("Ingrese el ID del evento: ");

        // Validamos que el usuario exista
        if (!usuarios.containsKey(email)) {
            System.out.println("El usuario no existe");
            return;
        }

        // Validamos que el evento exista
        if (!eventos.containsKey(idEvento)) {
            System.out.println("El evento no existe");
            return;
        }

        // Verificamos que no exista ya este favorito (opcional pero recomendado)
        for (Favorito fav : favoritos) {
            // Comparamos ambos campos para ver si ya existe la combinación
            if (fav.getCorreoUsuario().equals(email) && fav.getIdEvento() == idEvento) {
                System.out.println("Este favorito ya existe");
                return;
            }
        }

        // Creamos y añadimos el nuevo favorito
        Favorito nuevoFavorito = new Favorito(email, idEvento);
        favoritos.add(nuevoFavorito);

        System.out.println("Favorito creado correctamente");
    }

    // ---------- FUNCIÓN 8: ELIMINAR FAVORITO ----------
    /**
     * Elimina un favorito existente. Requiere el email del usuario y el ID del
     * evento.
     */
    private static void eliminarFavorito() {
        System.out.println("--- ELIMINAR FAVORITO ---");

        // Verificamos si hay favoritos
        if (favoritos.isEmpty()) {
            System.out.println("No hay favoritos registrados.");
            return;
        }

        // Mostramos los favoritos actuales
        mostrarFavoritos();

        // Solicitamos los datos para identificar el favorito
        String email = leerCadena("Ingrese el email del usuario: ");
        int idEvento = leerEntero("Ingrese el ID del evento: ");

        // Buscamos y eliminamos el favorito
        // Usamos un bucle tradicional para poder usar remove por índice
        boolean encontrado = false;

        for (int i = 0; i < favoritos.size(); i++) {
            Favorito fav = favoritos.get(i);
            // Comparamos ambos campos
            if (fav.getCorreoUsuario().equals(email) && fav.getIdEvento() == idEvento) {
                favoritos.remove(i);  // Eliminamos por índice
                encontrado = true;
                break;  // Salimos del bucle después de encontrar
            }
        }

        if (encontrado) {
            System.out.println("Favorito eliminado correctamente");
        } else {
            System.out.println("El favorito no existe");
        }
    }

    // ------------------------ MÉTODOS AUXILIARES DE VISUALIZACIÓN ------------------------
    /**
     * Muestra todos los usuarios registrados en formato tabular.
     */
    private static void mostrarUsuarios() {
        System.out.println("\n--- USUARIOS REGISTRADOS ---");

        if (usuarios == null || 0 == usuarios.size()) { // Verificamos si hay usuarios
            System.out.println("No hay usuarios registrados.");
            return;
        }

        // Encabezado de la tabla
        System.out.println(String.format("%-30s | %-20s", "EMAIL", "NOMBRE"));
        // String.format permite crear cadenas con formato y %-30s significa: string, 30 caracteres de ancho, alineado a la izquierda
        System.out.println("----------------------------------------------");

        // Iteración sobre los valores
        usuarios.values().forEach((Usuario usuario) -> {
            String email;
            String nombre;
            
            // --- Lógica para el EMAIL ---
            if (usuario.getEmail() != null) {
                email = usuario.getEmail();
            } else {
                email = "Sin email";
            }
            
            // --- Lógica para el NOMBRE ---
            if (usuario.getNombre() != null) {
                nombre = usuario.getNombre();
            } else {
                nombre = "Sin nombre";
            }
            
            // Imprimimos la fila con los datos ya validados
            System.out.println(String.format("%-30s | %-20s", email, nombre));
        });
    }

    /**
     * Muestra todos los eventos registrados en formato tabular.
     */
    private static void mostrarEventos() {
        System.out.println("\n--- EVENTOS REGISTRADOS ---");

        // 1. Verificación sin .isEmpty() y con control de nulos
        if (eventos == null || eventos.isEmpty()) {
            System.out.println("No hay eventos registrados.");
            return;
        }

        // 2. Definimos el formato una sola vez
        // %-5d es para enteros (digitos), los demás %s para Strings
        String formato = "%-5d | %-12s | %-20s | %-15s";

        // Encabezado
        System.out.println(String.format("%-5s | %-12s | %-20s | %-15s", "ID", "FECHA", "TÍTULO", "UBICACIÓN"));
        System.out.println("---------------------------------------------------------");

        // 3. Recorremos los eventos
        eventos.values().forEach((evento) -> {
            // --- Validación de Fecha ---
            String fecha;
            if (evento.getFecha() != null) {
                fecha = evento.getFecha();
            } else {
                fecha = "Sin fecha";
            }

            // --- Validación y Truncado de Título ---
            String titulo;
            if (evento.getTitulo() != null) {
                titulo = truncar(evento.getTitulo(), 20);
            } else {
                titulo = "Sin título";
            }

            // --- Validación y Truncado de Ubicación ---
            String ubicacion;
            if (evento.getUbicacion() != null) {
                ubicacion = truncar(evento.getUbicacion(), 15);
            } else {
                ubicacion = "Sin ubicación";
            }

            // 4. Impresión de la fila
            // Usamos %-5d para el ID porque es un número (int o long)
            System.out.println(String.format(formato, evento.getId(), fecha, titulo, ubicacion));
        });
    }

    /**
     * Muestra las galerías de un evento específico.
     *
     * @param evento El evento cuyas galerías se mostrarán
     */
    private static void mostrarGaleriasDeEvento(Evento evento) {
        // 1. Verificación de seguridad: ¿Existe el objeto evento?
        if (evento == null) {
            System.out.println("Error: El evento no existe.");
            return;
        }

        System.out.println("\n--- GALERÍAS DEL EVENTO '" + evento.getTitulo() + "' ---");

        // 2. Obtenemos la lista de galerías
        ArrayList<Galeria> galerias = evento.getGalerias();

        // 3. Verificamos la lista sin usar .isEmpty()
        if (galerias == null || galerias.isEmpty()) {
            System.out.println("Este evento no tiene galerías.");
            return;
        }

        // 4. Definimos el formato
        String formato = "%-5d | %-30s";

        // Encabezado
        System.out.println(String.format("%-5s | %-30s", "ID", "TÍTULO"));
        System.out.println("-----------------------------------");

        // 5. Recorremos las galerías (ArrayList)
        galerias.forEach((galeria) -> {
            // Validación de título nulo antes de truncar
            String titulo;
            if (galeria.getTitulo() != null) {
                titulo = truncar(galeria.getTitulo(), 30);
            } else {
                titulo = "Sin título";
            }

            // Impresión con el formato definido
            System.out.println(String.format(formato, galeria.getId(), titulo));
        });
    }

    /**
     * Muestra todos los favoritos registrados.
     */
    private static void mostrarFavoritos() {
        System.out.println("\n--- FAVORITOS REGISTRADOS ---");

        // 1. Verificación de la lista de favoritos (sin isEmpty)
        if (favoritos == null || favoritos.isEmpty()) {
            System.out.println("No hay favoritos registrados.");
            return;
        }

        // 2. Definimos el formato de la tabla  // %-30s (Email), %-10d (ID numérico), %-20s (Título)
        String formato = "%-30s | %-10d | %-20s";

        // Encabezado
        System.out.println(String.format("%-30s | %-10s | %-20s", "EMAIL USUARIO", "ID EVENTO", "TÍTULO EVENTO"));
        System.out.println("---------------------------------------------");

        // 3. Recorremos la colección de favoritos
        favoritos.forEach((fav) -> {
            // --- Validación del Correo ---
            String correo;
            if (fav.getCorreoUsuario() != null) {
                correo = fav.getCorreoUsuario();
            } else {
                correo = "Desconocido";
            }

            // Buscamos el objeto Evento en nuestro HashMap de eventos usando el ID
            Evento evento = eventos.get(fav.getIdEvento());

            String tituloEvento;
            if (evento != null && evento.getTitulo() != null) { // Si el evento existe y tiene título, lo truncamos                
                tituloEvento = truncar(evento.getTitulo(), 20);
            } else { // Si el evento fue borrado o no tiene título
                tituloEvento = "N/A o No se ha encontrado";
            }

            // 4. Impresión de la fila
            System.out.println(String.format(formato, correo, fav.getIdEvento(), tituloEvento));
        });
    }

    /**
     * Trunca una cadena si excede la longitud máxima. Añade "..." al final si
     * se trunca.
     *
     * @param texto El texto a truncar
     * @param maxLargo La longitud máxima permitida
     * @return El texto truncado o el original si no excede el límite
     */
    private static String truncar(String texto, int maxLargo) {
        if (texto == null) { // Si el texto es null, retornamos cadena vacía
            return "";
        }
        if (texto.length() <= maxLargo) { //Si el texto es más corto que el máximo, no hay nada que hacer
            return texto;
        }
        if (maxLargo <= 3) {//Verificamos que el maxLargo sea suficiente para poner los puntos "..."  Si el límite es muy pequeño (menor a 3)
            return texto.substring(0, maxLargo);
        }
        return texto.substring(0, maxLargo - 3) + "..."; //Truncamos y añadimos los puntos suspensivos
    }
}
