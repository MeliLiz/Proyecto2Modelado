/**
 * Clase de un administrador de la tienda de libros
 * Sirve para que el administrador pueda agregar libros a la colección de la tienda
 */
public class Admin {

    private String nombre;//nombre de usuario
    private String contrasena;
    private Tienda tienda;//la tienda de la que es administrador

    /**
     * Constructor 
     * @param tienda La tienda de la que será administrador
     * @param nombre El nombre de usuario del administrador
     * @param contrasena La contraseña del administrador
     */
    public Admin(Tienda tienda, String nombre, String contrasena){
        this.tienda=tienda;
        this.nombre=nombre;
        this.contrasena=contrasena;
    }

    /**
     * Método para obtener el nombre de usuario del administrador
     * @return String el nombre de usuario del administrador
     */
    public String getNombre() {
        return this.nombre;
    }

    /**
     * Método para asignar un nombre de usuario al administrador
     * @param nombre El nuevo nombre de usuario del administrador
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Método para obtener la contraseña de la cuenta del administrador
     * @return String la contraseña de la cuenta del administrador
     */
    public String getContrasena() {
        return this.contrasena;
    }

    /**
     * Método para cambiar la contraseña de la cuenta del administrador
     * @param contrasena La nueva contraseña de la cuenta del administrador
     */
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    /**
     * Método para obtener la tienda de la que se es administrador
     * @return Tienda la tienda asociada al administrador
     */
    public Tienda getTienda() {
        return this.tienda;
    }

    /**
     * Método para asignar la tienda asociada al administrador
     * @param tienda La tienda asociada al administrador
     */
    public void setTienda(Tienda tienda) {
        this.tienda = tienda;
    }

    
}
