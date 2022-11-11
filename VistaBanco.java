import java.util.Scanner;

/**
 * Clase de la vista del cajero del banco
 */
public class VistaBanco {
    private Cajero cajero;
    private Scanner scanner1 = new Scanner(System.in);// Scanner para líneas
    private Scanner scanner2 = new Scanner(System.in);// Scanner para números
    private Scanner scanner4 = new Scanner(System.in);// Scanner para double
    private Scanner scanner3 = new Scanner(System.in);// Scanner para long

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
            System.out.println("Bienvenido al banco \"La banca\"");
            System.out.println("¿Qué podemos hacer por ti?");
            System.out.println("1) Registrarse");
            System.out.println("2) Consultar saldo");
            System.out.println("3) Transferir dinero");
            System.out.println("4) Depositar");
            System.out.println("5) Retirar");
            System.out.println("0) Salir");
            System.out.print("Ingrese la opción: ");
            try {
                respuesta = scanner2.nextInt();
                if (respuesta >= 0 && respuesta < 6) {
                    cajero.menuPreguntasUsuario(respuesta);
                    break;
                } else {
                    System.out.println("No ingreso una opción válida");
                }
            } catch (Exception e) {
                System.out.println("No ingresó un número, vuelva a intentarlo");
            }
        }

    }

    /**
     * Método para salir al menú principal
     */
    public void salirAlMenuPrincipal() {
        System.out.println("Saliendo al menú principal...");
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
        System.out.print("Ingrese el nombre del Beneficiario: ");
        return scanner1.nextLine();
    }

    /**
     * Método para pedir el tipo de cuenta del cliente
     * 
     * @return Un scanner pidiendole al usuario su tipo de cuenta
     */
    public String pedirTipoCuenta() {
        System.out.println("¿Qué tipo de cuenta desea?");
        return scanner1.nextLine();
    }

    /**
     * Método para decirle al usuario que el registro de su cuenta fué exitoso
     */
    public void registroExitoso(CuentaBancaria nuevaCuenta) {
        System.out.println("Se ha registrado su cuenta existosamente");
        System.out.println("Los datos de cuenta:\n" + nuevaCuenta);
        salirAlMenuPrincipal();

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
    public long pedirNumCuenta(boolean tipoDeOperacion) {
        long cuenta = 0;
        while (true) {
            if (tipoDeOperacion == true) {
                System.out.print("Por favor ingresa tu cuenta bancaria: ");
            } else {
                System.out.println("Por favor ingrese el número de cuenta a la que se quiere transferir: ");
            }

            try {
                cuenta = scanner3.nextLong();
                break;
            } catch (Exception e) {
                System.out.println("No ingresaste un numero");
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
    public long consultarSaldo() {
        System.out.println("**Consulta de saldo**");

        return pedirNumCuenta(true);
    }

    /**
     * Método para mostrar el saldo de una cuenta
     * 
     * @param saldo            El número de cuenta
     * @param operacionExitosa Si la operacion que se realizo fue exitosa
     */
    public void mostrarSaldo(double saldo, boolean operacionExitosa) {
        if (operacionExitosa == true) {
            System.out.println("Su saldo es: $" + saldo);

        } else {
            mostrarError();
        }
        salirAlMenuPrincipal();

    }

    /**
     * Método para mostrar en pantalla que ha ocurrido un error
     */
    private void mostrarError() {
        System.out.println("Lo sentimos, ha ocurrido, un error, vuelva a intentarlo");
    }

    /**
     * Método para mostrar que hubo un error al ingresar el número de cuenta
     */
    public void mostrarErrorNumCuenta() {
        System.out.println("Lo sentimos, el número de cuenta que ha ingresado no existe, intente de nuevo");
        salirAlMenuPrincipal();
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
            if (operacion == true) {
                System.out.print("Por favor ingrese la cantidad que desea transferir: ");

            } else {
                System.out.print("Ingrese el dinero que sea depositar: ");
            }
            try {
                dineroOperacion = scanner2.nextDouble();
                break;
            } catch (Exception e) {
                System.out.println("No ingresaste un numero");
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
            System.out.print("Por favor ingrese su cvv: ");
            try {
                cvv = scanner2.nextInt();
                break;
            } catch (Exception e) {
                System.out.println("No ingresaste un numero");
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
            System.out.println("La transferencia se ha realizado con éxito");
        } else {
            mostrarError();
        }
        salirAlMenuPrincipal();
    }

    /**
     * Método para ver si un deposito fue exitoso
     * 
     * @param cuentaDepositada La cuenta a la que se le depositó
     * @param depositoExitoso  boolean para el éxito del depósito: true si el
     *                         depósito fue exitoso, false en otro caso
     */
    public void depositoExitoso(long numCuenta, boolean depositoExitoso) {
        if (depositoExitoso == true) {
            System.out.println("El depósito fue exitoso");
            mostrarSaldo(numCuenta, depositoExitoso);
        } else {
            System.out.println("Su depósito ha fallado, vuelva a intentarlo");
        }
        salirAlMenuPrincipal();
    }

    /**
     * Método para pedirle al usuario la cantidad de dinero que sea retirar
     * 
     * @return Un scanner con el dinero que el usuario desea retirar
     */
    public double retiro() {
        double retiro = 0;
        while (true) {
            System.out.print("Por favor ingrese la cantidad que desea retirar: ");
            try {
                retiro = scanner2.nextInt();
                break;
            } catch (Exception e) {
                System.out.println("No ingresaste un numero");
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
            System.out.println("Su retiro fue exitoso");
            mostrarSaldo(cantidadRetirada, retiroExitoso);
        } else {
            mostrarError();
        }
    }

}
