

/**
 *
 * @author ALUMNOS-FP
     * @version 1.0
     */
    public class Galerias {

        // ------------------ ATRIBUTOS ------------------
        private int id;         // Id único de la galería.
        private String titulo;  // Título descriptivo de la galería.
        private int idEvento;   // ID del evento al que pertenece (clave foránea).

        // ------------------ CONSTRUCTORES ------------------
        /**
         * Constructor vacío
         * Permite crear una galería sin inicializar valores
         */
        public Galerias() {

            // Constructor vacío - atributos quedan en valores por defecto
            // int queda en 0, String queda en null
        }

        /**
         * Constructor con parámetros
         * Crea una galería completa con todos sus datos
         * @param id Id único de la galería
         * @param titulo Título de la galería
         * @param idEvento ID del evento al que pertenece
         */
        public Galerias(int id, String titulo, int idEvento) {
            this.id = id;               // Asigna el ID
            this.titulo = titulo;       // Asigna el título
            this.idEvento = idEvento;   // Asigna el ID del evento
        }

        // ------------------ GETTERS ------------------
        /**
         * Obtiene el ID de la galería
         * @return int con el id
         */
        public int getId() {
            return id;
        }

        /**
         * Obtiene el título de la galería
         * @return String con el título
         */
        public String getTitulo() {
            return titulo;
        }

        /**
         * Obtiene el ID del evento asociado
         * @return int con el ID del evento padre
         */
        public int getIdEvento() {
            return idEvento;
        }

        // ------------------ SETTERS ------------------
        /**
         * Establece el ID de la galería
         * @param id Nuevo ID
         */
        public void setId(int id) {
            this.id = id;
        }

        /**
         * Establece el título de la galería
         * @param titulo Nuevo título
         */
        public void setTitulo(String titulo) {
            this.titulo = titulo;
        }

        /**
         * Establece el ID del evento asociado
         * @param idEvento Nuevo ID del evento
         */
        public void setIdEvento(int idEvento) {
            this.idEvento = idEvento;
        }

        // ------------------ MÉTODO toString ------------------
        /**
         * Representación en texto de la galería
         * @return String formateado con los datos de la galería
         */
        @Override
        public String toString() {
            return "Galeria{" + "id=" + id + ", titulo='" + titulo + '\''+ ", idEvento=" + idEvento + '}';
        }

    }
