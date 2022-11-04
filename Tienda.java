import java.util.Hashtable;
import java.util.Set;

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
    public Tienda(PayMe payme){
        usuarios=new Hashtable<>();
        admin=new Hashtable<>();
        coleccion=new Coleccion();
        payMe=payme;
        cuentaBancaria=0;////////////////////////////////////////////////////Registrar la cuenta
        numLibros=coleccion.getNumLibros();
    }

    /**
     * Método para verificar el nombre de usuario y contraseña de un cliente
     * @return booleaan true si el usuario y contraseña son válidos, false en otro caso
     */
    public boolean verificarUsuario(String usuario, String contrasena){
        Set<String> llaves = usuarios.keySet();

        for(String llave: llaves){
            if(llave.equals(usuario)&&usuarios.get(llave).getContrasena().equals(contrasena)){
                return true;
            }
        }
        return false;
    }

    /**
     * Método para verificar el nombre de usuario y contraseña de un administrador
     * @return booleaan true si el usuario y contraseña son válidos, false en otro caso
     */
    public boolean verificarAdmmin(String usuario, String contrasena){
        Set<String> llaves = admin.keySet();

        for(String llave: llaves){
            if(llave.equals(usuario)&&admin.get(llave).getContrasena().equals(contrasena)){
                return true;
            }
        }
        return false;
    }

    /**
     * Método para hacer el pago de una compra, se transfiere dinero de la cuenta del usuario a la cuenta de la tienda
     * @return boolean true si el pago fue exitoso, false en otro caso
     */
    public boolean hacerPago(double cantidad, int numCuentaBancaria, int cvv){
        return payMe.transferir(numCuentaBancaria, cvv, cuentaBancaria, cantidad);
    }

    /**
     * Método para verificar que exista una cuenta bancaria
     * @return
     */
    public boolean existeCuentaBancaria(int numCuentaBancaria){
        return payMe.existeCuenta(numCuentaBancaria);
    }

    /**
     * Método para registrar a un cliente
     */
    @Override
    public void registrar(Usuario usuario) {
        if(usuario!=null){
            usuarios.put(usuario.getNombreUsuario(), usuario);
        } 
    }

    /**
     * Método para remover a un cliente
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
}
