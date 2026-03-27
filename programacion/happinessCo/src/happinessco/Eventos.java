
import java.util.ArrayList;

/**
 *
 * @author ALUMNOS-FP
 */
public class Eventos {
    // --------------------- ATRIBUTOS ---------------------

    private int id;                         // Identificador único del evento ()
    private String fecha;                   // Fecha del evento en formato String
    private String titulo;                  // Título descriptivo del evento
    private String ubicacion;               // Lugar donde se realiza el evento
    private String descripcion;             // Descripción detallada del evento
    private ArrayList<Galerias> galerias;    // Lista de galerías asociadas al evento, la cual cambio el nombre por 
    // --------------------- CONSTRUCTORES ---------------------

    /**
     * Constructor vacío se inicializa la lista de galerías como ArrayList vacia
     */
    public Eventos() {
        this.galerias = new ArrayList<>();
    }

    /**
     * Constructor con parámetros Crea un evento completo con todos sus datos
     *
     * @param id Id único del evento
     * @param fecha Fecha del evento
     * @param titulo Título del evento
     * @param ubicacion Lugar del evento
     * @param descripcion Descripción del evento
     */
    public Eventos(int id, String fecha, String titulo, String ubicacion, String descripcion) {
        this.id = id;                       // Asigna el ID
        this.fecha = fecha;                 // Asigna la fecha
        this.titulo = titulo;               // Asigna el título
        this.ubicacion = ubicacion;         // Asigna la ubicación
        this.descripcion = descripcion;     // Asigna la descripción
        this.galerias = new ArrayList<>();  // Inicializa lista de galerías vacía
    }
    // --------------------- GETTERS ---------------------

    /**
     * Obtiene el ID del evento
     * @return int con el id del evento
     */
    public int getId() {
        return id;
    }

    /**
     * Obtiene la fecha del evento
     * @return String con la fecha
     */
    public String getFecha() {
        return fecha;
    }

    /**
     * Obtiene el título del evento
     * @return String con el título
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * Obtiene la ubicación del evento
     * @return String con la ubicación
     */
    public String getUbicacion() {
        return ubicacion;
    }

    /**
     * Obtiene la descripción del evento
     * @return String con la descripción
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Obtiene la lista de galerías del evento
     * @return ArrayList<Galerias> con todas las galerías
     */
    public ArrayList<Galerias> getGalerias() {
        return galerias;
    }
    // --------------------- SETTERS ---------------------

    /**
     * Establece el ID del evento
     * @param id Nuevo ID a asignar
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Establece la fecha del evento
     * @param fecha Nueva fecha a asignar
     */
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    /**
     * Establece el título del evento
     * @param titulo Nuevo título a asignar
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * Establece la ubicación del evento
     * @param ubicacion Nueva ubicación a asignar
     */
    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    /**
     * Establece la descripción del evento
     * @param descripcion Nueva descripción a asignar
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Establece la lista completa de galerías
     * @param galerias Nueva lista de galerías
     */
    public void setGalerias(ArrayList<Galerias> galerias) {
        this.galerias = galerias;
    }
    // --------------------- MÉTODOS AUXILIARES ---------------------

    /**
     * Agrega una galería a la lista del evento Método de conveniencia para no acceder directamente a la lista
     * @param galeria Galería a agregar
     */
    public void agregarGaleria(Galerias galeria) {
    if (galeria != null) {
        this.galerias.add(galeria);
    } else {
        System.out.println("Error: No se puede agregar una galería que no existe.");
    }
}
    /**
     * Elimina una galería de la lista por su ID Usa removeIf con expresión
     * @param idGaleria ID de la galería a eliminar
     * @return true si se eliminó, false si no existía
     */
    public boolean eliminarGaleria(int idGaleria) {
        // removeIf recorre la lista y elimina elementos que cumplan la condición
        // 'galeria.getId() == idGaleria' es la condición: si el ID coincide, se elimina
        return this.galerias.removeIf(galeria -> galeria.getId() == idGaleria);
    }

    /**
     * Buscar una galería por su ID
     * @param idGaleria ID de la galería a buscar
     * @return Galeria encontrada o null si no existe
     */
public Galerias buscarGaleria(int idGaleria) {
    for (int i = 0; i < galerias.size(); i++) { //es el .length de arraylist
        if (galerias.get(i).getId() == idGaleria) {
            return galerias.get(i);
        }
    }
    return null; // Si no se encontró, devuelve null
}   
    

    // --------------------- MÉTODO toString ---------------------

    /**
     * Representación en texto del evento Incluye información básica pero no las
     * galerías completas
     *
     * @return String formateado con los datos del evento
     */
    @Override
    public String toString() {
        return ", fecha='" + "Evento{" + "id=" + id + fecha + '\'' + ", titulo='"
                + titulo + '\'' + ", ubicacion='" + ubicacion + '\'' + ", descripcion='"
                + descripcion + '\'' + ", numGalerias=" + galerias.size() + '}';
    }

}
