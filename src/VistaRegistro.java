import java.util.Scanner;

/**
 * Clase de la vista de la clase que se encarga de registrar nuevos usuarios en
 * la tienda o iniciar la sesión de un usuario
 */
public class VistaRegistro {
    public static final String RESET = "\033[0m"; // para colores en la terminal
    public static final String ROJO = "\033[0;31m"; // para mensajes de error en la terminal
    public static final String CYAN = "\033[0;36m"; // color Cyan para los menus.
    public static final String VERDE = "\033[0;92m"; // para cuando se le indique al usuario ingresar una opción

    private Registro registro;// El registro asociaado
    private Scanner scanner1 = new Scanner(System.in);// Scanner para líneas
    private Scanner scanner2 = new Scanner(System.in);// Scanner para números
    private Scanner scanner3 = new Scanner(System.in);// Scanner para Long

    /**
     * Constructor
     * 
     * @param registro El registro de la tienda
     */
    public VistaRegistro(Registro registro) {
        this.registro = registro;
    }

    /**
     * Métdo para mostrar las opciones del registro de la tienda:
     * Registrarse, iniciar sesión o salir
     */
    public void menuOpciones() {
        int respuesta = 0;
        while (true) {
            System.out.println(CYAN + "\nBienvenid@ a InkSpace" + RESET);
            System.out.println("¿Qué desea hacer?");
            System.out.println("1) Registrarse");
            System.out.println("2) Iniciar sesión");
            System.out.println("3) Salir");
            System.out.print(VERDE + "Elija una opción: " + RESET);
            try {
                respuesta = scanner2.nextInt();
                System.out.println();
                if (respuesta > 0 && respuesta < 4) {
                    break;
                } else {
                    System.out.println(ROJO + "No ingresaste una opción válida" + ROJO);

                }

            } catch (Exception e) {
                System.out.println(ROJO + "\nNo ingresaste un número" + RESET);
                scanner2.next();
            }
        }
        registro.opcionesRegistro(respuesta);

    }

    /**
     * Método para pedir el nombre de usuario
     * 
     * @return String El nombre de usuario ingresado
     */
    public String pedirNombreUsuario() {
        System.out.print(VERDE + "Ingrese un nombre de usuario: " + RESET);
        String nombreUsuario = scanner1.nextLine();
        System.out.println();
        return nombreUsuario;
    }

    /**
     * Método para notificar que el nombre de usuario ingresado no es válido
     */
    public void nombreUsuarioNoValido() {
        System.out.println(ROJO + "El nombre de usuario ya está en uso, favor de elegir uno nuevo\n" + RESET);
    }

    /**
     * Método para pedir la contraseña del usuario
     * 
     * @return String La contraseña ingresada
     */
    public String pedirContrasena() {
        String respuesta;
        System.out.print(VERDE + "Ingresa tu contraseña: " + RESET);
        respuesta = scanner1.nextLine();
        System.out.println();
        return respuesta;
    }

    /**
     * Método para pedir el número de cuenta bancaria del usuario
     * 
     * @return Long El numero de cuenta bancaria ingresado
     */
    public Long pedirCuentaBancaria() {
        Long cuenta = 0L;
        while (true) {
            System.out.print(VERDE + "Por favor ingresa tu cuenta bancaria: " + RESET);
            try {
                cuenta = scanner3.nextLong();
                System.out.println();
                break;
            } catch (Exception e) {
                System.out.println(ROJO + "No ingresaste un numero\n" + RESET);
                scanner3.next();
            }
        }
        return cuenta;
    }

    /**
     * Método para notificar que la cuenta bancaria ingresada no está registrada en
     * el banco
     */
    public void numCuentaNoValido() {
        System.out.println(ROJO + "Al parecer el número de cuenta ingresado no existe\n" + RESET);
    }

    /**
     * Método para mostrar el menú con opciones de salir o ingresar otro numero de
     * cuenta por si el usuario ingresó anteriormente un número de cuenta no válido
     * 
     * @return int La respuesta del usuario: 1 si quiere salir, 2 si quiere ingresar
     *         otro número de cuenta
     */
    public int menuCuenta() {
        int respuesta = 0;
        while (true) {
            System.out.println(CYAN + "Tiene dos opciones:" + RESET);
            System.out.println("1) Salir para generar una cuenta en el banco \"La banca\"");
            System.out.println("2) Ingresar otro numero de cuenta");
            System.out.print(VERDE + "Ingrese una opción: " + RESET);
            try {
                respuesta = scanner2.nextInt();
                System.out.println();
                if (respuesta > 0 && respuesta < 3) {
                    break;
                } else {
                    System.out.println(ROJO + "No ingresaste una opción válida\n" + RESET);

                }
            } catch (Exception e) {
                System.out.println(ROJO + "No ingresaste un número" + RESET);
                scanner2.next();
            }
        }
        return respuesta;
    }

    /**
     * Método para solicitar nombre de usuario y contraseña para iniciar sesión
     */
    public void pedirUsuarioyContrasena() {
        System.out.print(VERDE + "Ingresa tu nombre de usuario: " + RESET);
        String nombreUsuario = scanner1.nextLine();
        System.out.print(VERDE + "Ingresa tu contraseña: " + RESET);
        String contrasena = scanner1.nextLine();

        String[] nombreContrasena = { nombreUsuario, contrasena };
        registro.iniciarSesion(nombreContrasena);
    }

    /**
     * Método para notificar que el nombre de usuario o contraseña no son válidos
     */
    public void usuarioNoRegistrado() {
        System.out.println(ROJO + "Nombre de usuario o contraseña no válidos, por favor intente de nuevo" + RESET);
        System.out.println(CYAN + "Saliendo al menú principal...\n" + RESET);
    }

    /**
     * Método para dar la despedida del registr de InkSpace
     */
    public void despedida() {
        System.out.println(CYAN + "\nGracias por visitar InkSpace" + RESET);
        System.out.println(CYAN + "Saliendo...\n" + RESET);
    }

    /**
     * Método para notificar que se ha registrado un usuario
     */
    public void registroExitoso() {
        System.out.println(CYAN + "Se ha registrado correctamente. Por favor inicie sesión\n" + RESET);
    }
}
