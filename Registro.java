/**
 * Clase para registrar nuevos usuarioas en la tienda o iniciar sesión de un usuario
 */
public class Registro {

    private Tienda tienda;
    private VistaRegistro vista;

    /**
     * Constructor
     * @param tienda La tienda que tiene el registro de usuarios
     */
    public Registro(Tienda tienda){
        this.tienda=tienda;
        vista=new VistaRegistro(this);
    }

    /**
     * Método para ir al menú de opciones del registro de la tienda: registrar, ingresar, salir
     */
    public void menuOpciones(){
        vista.menuOpciones();
    }

    /**
     * Método para hacer algo dependiendo de la respuesta del parámetro: registrar usuario, pedir datos de ingreso a una cuenta de usuario, salir
     * @param respuesta El número de la respuesta: 1 para registrarse, 2 para pedir datos de ingreso a una cuenta de usuario, 3 para salir
     */
    public void opcionesRegistro(int respuesta){
        switch (respuesta) {
            case 1:
                registrar();
                break;
            case 2:
                vista.pedirUsuarioyContrasena();
                break;
            case 3:
                salir();
                break;
            default:
                salir();
                break;
        }
    }

    /**
     * Método para registrar a un usuario en la tienda de libros
     */
    public void registrar(){
        String nombreUsuario=vista.pedirNombreUsuario();
        //Se verifica que el nombre de usuario escogino no esté en uso todavía
        while(tienda.existeNombreUsuario(nombreUsuario)){
            vista.nombreUsuarioNoValido();
            nombreUsuario=vista.pedirNombreUsuario();
        }
        String contrasena=vista.pedirContrasena();
        long numCuenta=vista.pedirCuentaBancaria();
        //Se verifica que la cuenta bancaria realmente existe en el banco
        while(!tienda.existeCuentaBancaria(numCuenta)){
            vista.numCuentaNoValido();
            int opcionUsuario=vista.menuCuenta();
            if(opcionUsuario==1){
                salir();
                break;
            }
            numCuenta=vista.pedirCuentaBancaria();
        }
        //Se registra el usuario
        Usuario usuario=new Usuario(nombreUsuario, contrasena, numCuenta);
        tienda.registrar(usuario);
        vista.registroExitoso();
        menuOpciones();
    }

    /**
     * Método para inicair sesión en la cuenta de un usuario
     * @param nombreContrasena El arreglo que contiene en [0] el nombre de usuario y el [1] la contraseña del usuario
     */
    public void iniciarSesion(String[] nombreContrasena){
        TiendaUsuario tiendaUsuario=null;
        //Se verifica si el usuario es administrador o usuario normal. Si el usuario (o administrador) está registrado, se dirige a la tiendaUsuario
        //Si no está registrado, se regresa al menú de opciones
        if(tienda.verificarAdmin(nombreContrasena[0], nombreContrasena[1])){
            tiendaUsuario=new TiendaUsuario(tienda,"admin");
            tiendaUsuario.inicio();
        }else if(tienda.verificarUsuario(nombreContrasena[0], nombreContrasena[1])){
            Usuario usuario=tienda.getUsuario(nombreContrasena[0]);
            tiendaUsuario=new TiendaUsuario(tienda, usuario, "usuario");
            tiendaUsuario.inicio();
        }else{
            vista.usuarioNoRegistrado();
            menuOpciones();
        }
    }

    /**
     * Método para salir del programa
     */
    public void salir(){
        vista.despedida();
    }
}
