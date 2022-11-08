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

    public void menuOpciones(){
        vista.menuOpciones();
    }

    /**
     * 
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

    public void registrar(){
        String nombreUsuario=vista.pedirNombreUsuario();
        while(tienda.existeNombreUsuario(nombreUsuario)){
            vista.nombreUsuarioNoValido();
            nombreUsuario=vista.pedirNombreUsuario();
        }
        String contrasena=vista.pedirContrasena();
        long numCuenta=vista.pedirCuentaBancaria();
        while(!tienda.existeCuentaBancaria(numCuenta)){
            vista.numCuentaNoValido();
            int opcionUsuario=vista.menuCuenta();
            if(opcionUsuario==1){
                salir();
                break;
            }
            numCuenta=vista.pedirCuentaBancaria();
        }
        Usuario usuario=new Usuario(nombreUsuario, contrasena, numCuenta);
        tienda.registrar(usuario);
    }


    public void iniciarSesion(String[] nombreContrasena){
        TiendaUsuario tiendaUsuario=null;
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

    public void salir(){
        vista.despedida();
    }
}
