import java.io.Serializable;

/**
 * Método que representa a un un usuario de la tienda de libros
 */
public class Usuario implements Observador, Serializable {
    private String nombreUsuario;
    private String contrasena;
    private Long cuentaBancaria;//El número de cuenta bancaria del usuario
    private Biblioteca biblioteca;//La biblioteca del usuario
    private int numLibrosGratis = 0;//El número de libros gratis que tiene la tienda desde la última visita del usuario

    /**
     * Constructor de un usuario
     * @param usuario El nombre del usuario
     * @param contrasena La contraseña del usuario
     * @param cuentaBancaria El numero de cuenta bancaria del usuario
     */
    public Usuario(String usuario, String contrasena, Long cuentaBancaria) {
        nombreUsuario = usuario;
        this.contrasena = contrasena;
        this.cuentaBancaria = cuentaBancaria;
        biblioteca = new Biblioteca();
    }

    /**
     * Método para obtener la biblioteca del usuario
     * @return Biblioteca La biblioteca del usuario
     */
    public Biblioteca getBiblioteca() {
        return biblioteca;
    }

    /**
     * Método para obtener el nombre de usuario
     * @return String El nombre de usuario
     */
    public String getNombreUsuario() {
        return nombreUsuario;
    }

    /**
     * Método para obtener la contraseña del usuario
     * @return String la contraseña del usuario
     */
    public String getContrasena() {
        return contrasena;
    }

    /**
     * Método para obtener el número de libros gratis en la tienda desde la ultima vez que entró el usuario a su cuenta
     * @return int El número de libros gratis en la tienda desde la ultima vez que entró el usuario a su cuenta
     */
    public int getNumLibrosGratis() {
        return numLibrosGratis;
    }

    /**
     * Método para asignar el número de libros gratis en la tienda desde la ultima vez que entró el usuario a su cuenta
     * @param numLibrosGratis El número de libros gratis en la tienda desde la ultima vez que entró el usuario a su cuenta
     */
    public void setNumLibrosGratis(int numLibrosGratis) {
        this.numLibrosGratis = numLibrosGratis;
    }

    /**
     * Método para obtener el número de cuenta bancaria del usuario
     * @return Long El número de cuenta bancaria del usuario
     */
    public Long getNumeroDeCuenta() {
        return this.cuentaBancaria;
    }

    /**
     * Método para actualizar cuando se registra un libro gratis en la tienda
     */
    @Override
    public void actualizar() {
        numLibrosGratis++;
    }

}
