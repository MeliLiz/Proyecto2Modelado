import java.util.Hashtable;
import java.util.Set;

/**
 * Clase que simula una tienda de libros
 */
public class Tienda implements SujetoObservable {
    private Hashtable<String, Usuario> usuarios;
    private Hashtable<String, Admin> admin;
    Coleccion coleccion;
    PayMe payMe;
    Long cuentaBancaria;
    int numLibros;


    /**
     * Constructor
     */
    public Tienda(PayMe payme) {
        usuarios = new Hashtable<>();
        admin = new Hashtable<>();
        coleccion = new Coleccion();
        payMe = payme;
        cuentaBancaria = 0L;//////////////////////////////////////////////////// Registrar la cuenta
        numLibros = coleccion.getNumLibros();
    }

    /**
     * Método para verificar el nombre de usuario y contraseña de un cliente
     * 
     * @return booleaan true si el usuario y contraseña son válidos, false en otro
     *         caso
     */
    public boolean verificarUsuario(String usuario, String contrasena) {
        Set<String> llaves = usuarios.keySet();

        for (String llave : llaves) {
            if (llave.equals(usuario) && usuarios.get(llave).getContrasena().equals(contrasena)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Método para verificar el nombre de usuario y contraseña de un administrador
     * 
     * @return booleaan true si el usuario y contraseña son válidos, false en otro
     *         caso
     */
    public boolean verificarAdmin(String usuario, String contrasena) {
        Set<String> llaves = admin.keySet();

        for (String llave : llaves) {
            if (llave.equals(usuario) && admin.get(llave).getContrasena().equals(contrasena)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Método para hacer el pago de una compra, se transfiere dinero de la cuenta
     * del usuario a la cuenta de la tienda
     * 
     * @return boolean true si el pago fue exitoso, false en otro caso
     */
    public boolean hacerPago(double cantidad, Long numCuentaBancaria, int cvv) {
        return payMe.transferir(numCuentaBancaria, cvv, cuentaBancaria, cantidad);
    }

    /**
     * Método para verificar que exista una cuenta bancaria
     * 
     * @return
     */
    public boolean existeCuentaBancaria(Long numCuentaBancaria) {
        return payMe.existeCuenta(numCuentaBancaria);
    }

    /**
     * Método para verificar si un nombre de usuario ya está registrado
     * 
     * @param nombreUsuario El nombre de usuario por verificar
     * @return boolean true si ya existe el nombre de usuario, false en otro caso
     */
    public boolean existeNombreUsuario(String nombreUsuario) {
        Set<String> llavesAdmin = admin.keySet();
        Set<String> llavesUsuarios = usuarios.keySet();

        for (String llave : llavesAdmin) {
            if (llave.equals(nombreUsuario)) {
                return true;
            }
        }
        for (String llave : llavesUsuarios) {
            if (llave.equals(nombreUsuario)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Método para registrar a un cliente
     * @param El usuario a registrar
     */
    @Override
    public void registrar(Usuario usuario) {
        if (usuario != null) {
            usuarios.put(usuario.getNombreUsuario(), usuario);
        }
    }

    /**
     * Método para remover a un cliente
     * @param usuario El usuario a quitar del registro
     */
    @Override
    public void remover(Usuario usuario) {
        usuarios.remove(usuario.getNombreUsuario());
    }

    /**
     * Método para notificar a un cliente que hay un libro nuevo gratuito
     */
    @Override
    public void notificar() {
        Set<String> llaves = usuarios.keySet();
        for (String llave : llaves) {
            usuarios.get(llave).actualizar();
        }

    }

    /**
     * Método para registrar a un nuevo administrador de la tienda
     * @param nuevoAdmin El nuevo administrador de la tienda
     */
    public void registrarAdmin(Admin nuevoAdmin) {
        admin.put(nuevoAdmin.getNombre(), nuevoAdmin);
    }

    /**
     * Método para obtener a un usuario registrado
     * @param nombreUsuario El nombre del usuario
     * @return El usuario registrado, null si el usuario no está registrado
     */
    public Usuario getUsuario(String nombreUsuario) {
        Set<String> llaves = usuarios.keySet();
        for (String llave : llaves) {
            if (llave.equals(nombreUsuario)) {
                return usuarios.get(llave);
            }
        }
        return null;
    }

    /**
     * Método para mostrar la colección de libros disponibles
     * @return String Los datos de los libros en la colección
     */
    public String mostrarCatalogo() {
        return coleccion.toString();
    }

    /**
     * Método para obtener un libro de la coleccion
     * @param id El número de identificador del libro
     * @return El libro buscado, null si el id no corresponde a algún libro
     */
    public Libro getLibro(int id) {
        return coleccion.getLibro(id);
    }

    /**
     * Método para obtener el número de libros que tiene la tienda
     * @return
     */
    public int getNumLibros() {
        return this.numLibros;
    }

    /**
     * Método para asignar el número de libros que tiene la tienda
     * @param numLibros El número de libros en la colección de libros de la tienda
     */
    public void setNumLibros(int numLibros) {
        this.numLibros = numLibros;
    }

    /**
     * Método para agregar un libro a la colección de libros
     * @param libro El libro a agregar a la colección
     */
    public void addLibro(Libro libro){
        coleccion.addLibro(libro);
        numLibros+=1;
        //Si el libro registrado es gratis, notificamos a los usuarios que hay un libro nuevo gratis
        if(libro.getPrecio()==0){
            notificar();
        }
    }
}
