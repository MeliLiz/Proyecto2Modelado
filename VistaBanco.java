import java.util.Scanner;

/**
 * Clase de la vista del cajero del banco
 */
public class VistaBanco {
    public static final String RESET = "\033[0m"; // para colores en la terminal
    public static final String ROJO = "\033[0;31m"; // para mensajes de error en la terminal
    public static final String CYAN = "\033[0;36m"; // color Cyan para los menus.
    public static final String VERDE = "\033[0;92m"; // para cuando se le indique al usuario ingresar una opción
    public static final String MORADO = "\033[0;95m"; // color morado para resaltar algunas cosas como el nombre del
                                                      // libro al momento de añadirlo al carrito

    private Cajero cajero;
    private Scanner scanner1 = new Scanner(System.in);// Scanner para líneas
    private Scanner scanner2 = new Scanner(System.in);// Scanner para números
    private Scanner scanner4 = new Scanner(System.in);// Scanner para double
    private Scanner scanner3 = new Scanner(System.in);// Scanner para Long

    /**
     * Constructor
     * 
     * @param cajero El cajero de la vista
     */
    public VistaBanco(Cajero cajero) {
        this.cajero = cajero;
    }

    /**
     * Método para el menú principal del banco
     */
    public void menuPreguntasUsuario() {
        int respuesta = 0;
        while (true) {
            System.out.println(CYAN + "Bienvenido al banco \"La banca\"" + RESET);
            System.out.println("¿Qué podemos hacer por ti?");
            System.out.println("1) Registrarse");
            System.out.println("2) Consultar saldo");
            System.out.println("3) Transferir dinero");
            System.out.println("4) Depositar");
            System.out.println("5) Retirar");
            System.out.println("0) Salir");
            System.out.print(VERDE + "Ingrese la opción: " + RESET);
            try {
                respuesta = scanner2.nextInt();
                System.out.println();
                if (respuesta >= 0 && respuesta < 6) {
                    cajero.menuPreguntasUsuario(respuesta);
                    break;
                } else {
                    System.out.println(ROJO + "No ingreso una opción válida\n" + RESET);

                }
            } catch (Exception e) {
                System.out.println(ROJO + "\nNo ingresó un número, vuelva a intentarlo\n" + RESET);
                scanner2.next();
            }
        }

    }

    /**
     * Método para salir al menú principal
     */
    public void salirAlMenuPrincipal() {
        System.out.println(CYAN + "Saliendo al menú principal...\n" + RESET);
        menuPreguntasUsuario();
    }

    /**
     * Método para registar a un usuario
     * 
     * @return Un arreglo que contiene el nombre del beneficiario y el tipo de
     *         cuenta que desea
     */
    public String[] registrarse() {
        String beneficiario = pedirNombreBeneficiario();
        String tipoDecuenta = pedirTipoCuenta();

        String[] respuestas = { beneficiario, tipoDecuenta };
        return respuestas;

    }

    /**
     * Método para pedir el nombre del beneficiario de la cuenta de banco
     * 
     * @return un scanner que le pide el nombre del beneficiario al usuario
     */
    public String pedirNombreBeneficiario() {
        System.out.print(VERDE + "Ingrese el nombre del Beneficiario: " + RESET);
        String nombre = scanner1.nextLine();
        System.out.println();
        return nombre;
    }

    /**
     * Método para pedir el tipo de cuenta del cliente
     * 
     * @return Un scanner pidiendole al usuario su tipo de cuenta
     */
    public String pedirTipoCuenta() {
        int respuesta = 0;
        while (true) {
            System.out.println(CYAN + "¿Qué tipo de cuenta desea?" + RESET);
            System.out.println("1) Basica: Límite de retiro y limite de deposito con interés: 3% a partir de $2000");
            System.out.println("2) Premium: Sin límites.");
            System.out.print(VERDE + "Elija una opción: " + RESET);
            try {
                respuesta = scanner2.nextInt();
                System.out.println();
                if (respuesta >= 0 && respuesta < 3) {
                    if (respuesta == 1) {
                        return "basica";
                    } else if (respuesta == 2) {
                        return "premium";
                    }
                    break;
                } else {
                    System.out.println(ROJO + "No ingreso una opción válida\n" + RESET);
                }
            } catch (Exception e) {
                System.out.println(ROJO + "\nNo ingresó un número, vuelva a intentarlo\n" + RESET);
                scanner2.next();
            }
        }
        return scanner1.nextLine();
    }

    /**
     * Método para decirle al usuario que el registro de su cuenta fué exitoso
     */
    public void registroExitoso(CuentaBancaria nuevaCuenta) {
        System.out.println(CYAN + "Se ha registrado su cuenta existosamente" + RESET);
        System.out.println(MORADO + "Es importante que guarde sus datos" + RESET);
        System.out.println("Los datos de su cuenta:\n" + nuevaCuenta);
    }

    /**
     * Método que le pide al usuario su número de cuenta
     * 
     * @return Un scanner que
     * @param tipoDeOperacion Un boolean para ver qúe tipo de operacion se hará:
     *                        true si es cuando quieres consultar el saldo o
     *                        depositar dinero a tu cuenta, false cuando se quiere
     *                        transferir dinero a otra cuenta
     */
    public Long pedirNumCuenta(boolean tipoDeOperacion) {
        Long cuenta = 0L;
        while (true) {// depositar
            if (tipoDeOperacion == true) {
                System.out.print(VERDE + "Por favor ingresa tu cuenta bancaria: " + RESET);
            } else {// retirar
                System.out.print(
                        VERDE + "Por favor ingrese el número de cuenta a la que se quiere transferir: " + RESET);
            }

            try {
                cuenta = scanner3.nextLong();
                break;
            } catch (Exception e) {
                System.out.println(ROJO + "\nNo ingresaste un numero\n" + RESET);
                scanner3.next();
            }
        }
        return cuenta;
    }

    /**
     * Método para consultar el saldo de una cuenta
     * 
     * @return El número de cuenta del usuario
     */
    public Long consultarSaldo() {
        System.out.println(CYAN + "**Consulta de saldo**" + RESET);

        return pedirNumCuenta(true);
    }

    /**
     * Método para mostrar el saldo de una cuenta
     * 
     * @param saldo El número de cuenta
     */
    public void mostrarSaldo(double saldo) {
        System.out.println(CYAN + "Su saldo es de: $" + RESET + saldo + "\n");

    }

    /**
     * Método para mostrar en pantalla que ha ocurrido un error
     */
    private void mostrarError() {
        System.out.println(
                ROJO + "\nLo sentimos, no pudimos realizar la operación requerida con su cuenta, por favor revise el estado de su cuenta\n"
                        + RESET);
    }

    /**
     * Método para mostrar que hubo un error al ingresar el número de cuenta
     */
    public void mostrarErrorNumCuenta() {
        System.out.println(
                ROJO + "\nLo sentimos, el número de cuenta que ha ingresado no existe, intente de nuevo\n" + RESET);
    }

    /**
     * Método para mostrar error si el cvv ingreado por el usuario no existe
     */
    public void mostrarErrorCVV() {
        System.out.println(
                ROJO + "\nLo sentimos, el cvv que ha ingresado no existe, intente de nuevo\n" + RESET);
    }

    /**
     * Método que solicita al usuario la cantidad a transferir
     * 
     * @return Un scanner que pide el dinero al usuario, ya sea para depositar, o
     *         para transferir
     * @param operacion Un boolean para una operacion distinta: true si quiere
     *                  transferir dinero, false si quiere depositar
     */
    public double pedirDineroOperacion(boolean operacion) {
        double dineroOperacion = 0;
        while (true) {
            if (operacion) {// transferir
                System.out.print(VERDE + "Por favor ingrese la cantidad que desea transferir: " + RESET);

            } else {// depositar
                System.out.print(VERDE + "Ingrese el dinero que desea depositar: " + RESET);
            }
            try {
                dineroOperacion = scanner2.nextDouble();
                System.out.println();
                break;
            } catch (Exception e) {
                System.out.println(ROJO + "No ingresaste un numero\n" + RESET);
                scanner2.next();
            }
        }
        return dineroOperacion;
    }

    /**
     * Método que le pide el cvv al usuario
     * 
     * @return Un scanner con la opcion del usuario
     */
    public int pedirCVV() {
        int cvv = 0;
        while (true) {
            System.out.print(VERDE + "Por favor ingrese su cvv: " + RESET);
            try {
                cvv = scanner2.nextInt();
                break;
            } catch (Exception e) {
                System.out.println(ROJO + "No ingresaste un numero\n" + RESET);
                scanner2.next();
            }
        }
        return cvv;
    }

    /**
     * Método para ver si se ha realizado una transferencia exitosa
     * 
     * @param exito Un boolean para ver si se ha realizado con exito la
     *              transferencia:
     *              true para exito, false en otro caso
     */
    public void transferenciaExitosa(boolean exito) {
        if (exito == true) {
            System.out.println(CYAN + "\nLa transferencia se ha realizado con éxito\n" + RESET);
        } else {
            mostrarError();
        }
    }

    /**
     * Método para ver si un deposito fue exitoso
     * 
     * @param cuentaDepositada La cuenta a la que se le depositó
     * @param depositoExitoso  boolean para el éxito del depósito: true si el
     *                         depósito fue exitoso, false en otro caso
     */
    public void depositoExitoso(double saldo, boolean depositoExitoso) {
        if (depositoExitoso == true) {
            System.out.println(CYAN + "El depósito fue exitoso" + RESET);
            mostrarSaldo(saldo);
        } else {
            mostrarErrorNumCuenta();
        }
    }

    /**
     * Método para pedirle al usuario la cantidad de dinero que sea retirar
     * 
     * @return Un scanner con el dinero que el usuario desea retirar
     */
    public double retiro() {
        double retiro = 0;
        while (true) {
            System.out.print(VERDE + "Por favor ingrese la cantidad que desea retirar: " + RESET);
            try {
                retiro = scanner2.nextInt();
                System.out.println();
                break;
            } catch (Exception e) {
                System.out.println(ROJO + "No ingresaste un numero\n" + RESET);
                scanner2.next();
            }
        }
        return retiro;
    }

    /**
     * Método para ver si un retiro fue exitoso
     * 
     * @param cantidadRetirada La cuenta a la que se le hizo el retiro
     * @param retiroExitoso    boolean para ver si el retiro fue exitoso: true si lo
     *                         fue, false en otro caso
     */
    public void retiroExitoso(double cantidadRetirada, boolean retiroExitoso) {
        if (retiroExitoso == true) {
            System.out.println(CYAN + "Su retiro fue exitoso" + RESET);
            System.out.println("Se han retirado $" + cantidadRetirada + " de su cuenta\n");
        } else {
            mostrarError();
        }
    }

}
