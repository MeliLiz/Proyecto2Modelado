import java.util.Scanner;

/**
 * Clase de la vista de la clase que se encarga de registrar nuevos usuarios en la tienda o iniciar la sesión de un usuario
 */
public class VistaRegistro {
    private Registro registro;
    private Scanner scanner1=new Scanner(System.in);//Scanner para líneas
    private Scanner scanner2=new Scanner(System.in);//Scanner para números
    private Scanner scanner3=new Scanner(System.in);//Scanner para long

    /**
     * Constructor
     * @param registro El registr de la tienda
     */
    public VistaRegistro(Registro registro){
        this.registro=registro;
    }

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

    public String pedirNombreUsuario(){
        System.out.println("Ingrese un nombre de usuario");
        String nombreUsuario=scanner1.nextLine();
        return nombreUsuario;
    }

    public void nombreUsuarioNoValido(){
        System.out.println("El nombre de usuario ya está en uso, favor de elegir uno nuevo");
    }

    public String pedirContrasena(){
        System.out.println("Ingresa tu contraseña");
        return scanner1.nextLine();
    }

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

    public void numCuentaNoValido(){
        System.out.println("Al parecer el número de cuenta ingresado no existe");
    }

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

    public void pedirUsuarioyContrasena(){
        System.out.println("Ingresa tu nombre de usuario");
        String nombreUsuario=scanner1.nextLine();
        System.out.println("Ingresa tu contraseña");
        String contrasena=scanner1.nextLine();
        String[] nombreContrasena={nombreUsuario,contrasena};
        registro.iniciarSesion(nombreContrasena);
    }

    public void usuarioNoRegistrado(){
        System.out.println("Nombre de usuario y contraseña no válidos");
    }

    public void despedida(){
        System.out.println("Gracias por visitar InkSpace");
        System.out.println("Saliendo...");
    }
}
