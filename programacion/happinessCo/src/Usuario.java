
/**
 *
 * @author ALUMNOS-FP
 */
public class Usuario {

    // ------------------- ATRIBUTOS -------------------
    // Todos los atributos son privados para garantizar encapsulación para llamarlos a travéz de los Getters y los Setters
    private String nombre;    // Nombre completo del usuario
    private String email;     // Email único que identifica al usuario (actúa como clave)
    private String password;  // Contraseña del usuario
    // ------------------- CONSTRUCTORES -------------------

    /**
     * Constructor vacío (sin parámetros) crear objetos, sin inicializar valores
     * Se usa para cuando se quieren establecer los valores después con setters
     */
    public Usuario() {
        // No inicializamos nada, los valores quedan como null
    }

    /**
     * Constructor con parámetros Permite crear un Usuario completo en una sola
     * línea
     *
     * @param nombre Nombre completo del usuario
     * @param email Email único del usuario
     * @param password Contraseña del usuario
     */
    public Usuario(String nombre, String email, String password) {
        this.nombre = nombre;       // Asigna el parámetro 'nombre' al atributo 'nombre'
        this.email = email;         // Asigna el parámetro 'email' al atributo 'email'
        this.password = password;   // Asigna el parámetro 'password' al atributo 'password'
    }
    // ------------------- GETTERS -------------------
    // Los getters permiten LEER los valores de los atributos privados

    /**
     * Obtiene el nombre del usuario
     *
     * @return String con el nombre completo del usuario
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Obtiene el email del usuario
     *
     * @return String con el email del usuario
     */
    public String getEmail() {
        return email;
    }

    /**
     * Obtiene la contraseña del usuario
     *
     * @return String con la contraseña del usuario
     */
    public String getPassword() {
        return password;
    }
    // ------------------- SETTERS -------------------
    // Los setters permiten MODIFICAR los valores de los atributos privados

    /**
     * Establece el nombre del usuario
     *
     * @param nombre Nuevo nombre a asignar
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Establece el email del usuario
     *
     * @param email Nuevo email a asignar
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Establece la contraseña del usuario
     *
     * @param password Nueva contraseña a asignar
     */
    public void setPassword(String password) {
        this.password = password;
    }
    // ------------------- MÉTODO toString -------------------

    /**
     * Devuelve una representación en texto del objeto Usuario Sobreescribe
     * (@Override) el método toString de la clase Object Se llama
     * automáticamente cuando se imprime el objeto con System.out.println()
     *
     * @return String con formato legible de los datos del usuario
     */
    @Override
    public String toString() {

        // No se incluye la contraseña "password" por seguridad
        return "Usuario:\n"
                + "nombre: " + nombre + "\n"
                + "email: " + email + "\n";
    }
}
