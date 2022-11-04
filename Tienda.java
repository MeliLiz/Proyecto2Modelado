import java.util.Hashtable;

/**
 * Clase que simula una tienda de libros
 */
public class Tienda implements SujetoObservable{
    private Hashtable<String, Usuario> usuarios;
    private Hashtable<String, Usuario> admin;
    Coleccion coleccion;
    PayMe payMe;
    int cuentaBancaria;
    int numLibros;

    /**
     * Constructor
     */
    public Tienda(){
        usuarios=new Hashtable<>();
        admin=new Hashtable<>();
        coleccion=new Coleccion();
        payMe=new PayMe();
        cuentaBancaria=0;////////////////////////////////////////////////////
        numLibros=coleccion.getNumLibros();
    }

    /**
     * Método para verificar el nombre de usuario y contraseña de un cliente
     * @return booleaan true si el usuario y contraseña son válidos, false en otro caso
     */
    public boolean verificarUsuario(String usuario, String contrasena){
        return true;
    }

    /**
     * Método para verificar el nombre de usuario y contraseña de un administrador
     * @return booleaan true si el usuario y contraseña son válidos, false en otro caso
     */
    public boolean verificarAdmmin(String usuario, String contrasena){
        return true;
    }

    /**
     * Método para hacer el pago de una compra
     * @return boolean true si el pago fue exitoso, false en otro caso
     */
    public boolean hacerPago(double cantidad, int numCuentaCancaria, int cvv){
        return true;
    }

    /**
     * Método para verificar que exista una cuenta bancaria
     * @return
     */
    public boolean existeCuentaBancaria(){
        return true;
    }

    /**
     * Método para registrar a un cliente
     */
    @Override
    public void registrar(Observador Usuario) {
        // TODO Auto-generated method stub
        
    }

    /**
     * Método para remover a un cliente
     */
    @Override
    public void remover(Observador usuario) {
        // TODO Auto-generated method stub
        
    }

    /**
     * Método para notificar a un cliente que hay un libro nuevo gratuito
     */
    @Override
    public void notificar() {
        // TODO Auto-generated method stub
        
    }
}
