import java.util.Scanner;

/**
 * Clase de la vista de la clase que se encarga de registrar nuevos usuarios en la tienda o iniciar la sesión de un usuario
 */
public class VistaRegistro {
    private Registro registro;//El registro asociaado
    private Scanner scanner1=new Scanner(System.in);//Scanner para líneas
    private Scanner scanner2=new Scanner(System.in);//Scanner para números
    private Scanner scanner3=new Scanner(System.in);//Scanner para long

    /**
     * Constructor
     * @param registro El registro de la tienda
     */
    public VistaRegistro(Registro registro){
        this.registro=registro;
    }

    /**
     * Métdo para mostrar las opciones del registro de la tienda:
     * Registrarse, iniciar sesión o salir
     */
    public void menuOpciones(){
        int respuesta=0;
        while(true){
            System.out.println("Bienvenid@ a InkSpace");
            System.out.println("Elige una opción");
            System.out.println("1) Registrarse");
            System.out.println("2) Iniciar sesión");
            System.out.println("3) Salir");
            try {
                respuesta=scanner2.nextInt();
                if(respuesta>0 && respuesta<4){
                    break;
                }else{
                    System.out.println("No ingresaste una opción válida");
                }
                
            } catch (Exception e) {
                System.out.println("No ingresaste un número");
            }
        }
        registro.opcionesRegistro(respuesta);

    }

    /**
     * Método para pedir el nombre de usuario
     * @return String El nombre de usuario ingresado
     */
    public String pedirNombreUsuario(){
        System.out.println("Ingrese un nombre de usuario");
        String nombreUsuario=scanner1.nextLine();
        return nombreUsuario;
    }

    /**
     * Método para notificar que el nombre de usuario ingresado no es válido
     */
    public void nombreUsuarioNoValido(){
        System.out.println("El nombre de usuario ya está en uso, favor de elegir uno nuevo");
    }

    /**
     * Método para pedir la contraseña del usuario
     * @return String La contraseña ingresada
     */
    public String pedirContrasena(){
        System.out.println("Ingresa tu contraseña");
        return scanner1.nextLine();
    }

    /**
     * Método para pedir el número de cuenta bancaria del usuario
     * @return long El numero de cuenta bancaria ingresado
     */
    public long pedirCuentaBancaria(){
        long cuenta=0;
        while(true){
            System.out.println("Por favor ingresa tu cuenta bancaria");
            try{
                cuenta=scanner3.nextLong();
                break;
            }catch(Exception e){
                System.out.println("No ingresaste un numero");
            }
        }
        return cuenta; 
    }

    /**
     * Método para notificar que la cuenta bancaria ingresada no está registrada en el banco
     */
    public void numCuentaNoValido(){
        System.out.println("Al parecer el número de cuenta ingresado no existe");
    }

    /**
     * Método para mostrar el menú con opciones de salir o ingresar otro numero de cuenta por si el usuario ingresó anteriormente un número de cuenta no válido
     * @return int La respuesta del usuario: 1 si quiere salir, 2 si quiere ingresar otro número de cuenta
     */
    public int menuCuenta(){
        int respuesta=0;
        while(true){
            System.out.println("Selecciona una opción");
            System.out.println("1) Salir para generar una cuenta en el banco \"La banca\"");
            System.out.println("2) Ingresar otro numero de cuenta");
            try {
                respuesta=scanner2.nextInt();
                if(respuesta>0&&respuesta<3){
                    break;
                }else{
                    System.out.println("No ingresaste una opción válida");
                }
            } catch (Exception e) {
                System.out.println("No ingresaste un número");
            }
        }
        return respuesta;  
    }

    /**
     * Método para solicitar nombre de usuario y contraseña para iniciar sesión
     */
    public void pedirUsuarioyContrasena(){
        System.out.println("Ingresa tu nombre de usuario");
        String nombreUsuario=scanner1.nextLine();
        System.out.println("Ingresa tu contraseña");
        String contrasena=scanner1.nextLine();
        String[] nombreContrasena={nombreUsuario,contrasena};
        registro.iniciarSesion(nombreContrasena);
    }

    /**
     * Método para notificar que el nombre de usuario o contraseña no son válidos
     */
    public void usuarioNoRegistrado(){
        System.out.println("Nombre de usuario o contraseña no válidos");
    }

    /**
     * Método para dar la despedida del registr de InkSpace
     */
    public void despedida(){
        System.out.println("Gracias por visitar InkSpace");
        System.out.println("Saliendo...");
    }
}
