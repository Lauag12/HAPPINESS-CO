/**
 *
 * @author ALUMNOS-FP
 */
public class Favorito {
    
   // ----------------------- ATRIBUTOS -----------------------
   private String correoUsuario;   // Email del usuario que marcó como favorito
   private int idEvento;           // ID del evento marcado como favorito
   // ----------------------- CONSTRUCTORES -----------------------
   /**
    * Constructor vacío
    * Permite crear un favorito sin inicializar valores
    */
   public Favorito() {
       // Constructor vacío
   }
   /**
    * Constructor con parámetros
    * Crea un apartado de favorito completo con la relación usuario-evento
    * @param correoUsuario Email del usuario
    * @param idEvento      ID del evento favorito
    */
   public Favorito(String correoUsuario, int idEvento) {
       this.correoUsuario = correoUsuario;     // Asigna el email del usuario
       this.idEvento = idEvento;               // Asigna el ID del evento
   }
   // ----------------------- GETTERS -----------------------
   /**
    * Obtiene el correo del usuario
    * @return String con el email
    */
   public String getCorreoUsuario() {
       return correoUsuario;
   }
   /**
    * Obtiene el ID del evento favorito
    * @return int con el ID del evento
    */
   public int getIdEvento() {
       return idEvento;
   }
   // ----------------------- SETTERS -----------------------
   /**
    * Establece el correo del usuario
    * @param correoUsuario Nuevo email
    */
   public void setCorreoUsuario(String correoUsuario) {
       this.correoUsuario = correoUsuario;
   }
   /**
    * Establece el ID del evento
    * @param idEvento Nuevo ID del evento a asignar
    */
   public void setIdEvento(int idEvento) {
       this.idEvento = idEvento;
   }
   // ----------------------- MÉTODO toString -----------------------
   /**
    * Representación en texto del favorito
    *
    * @return String formateado con la relación usuario-evento
    */
   @Override
   public String toString() {
       return "Favorito{" + "correoUsuario='" + correoUsuario + '\'' + ", idEvento=" + idEvento +'}';
   }
}

