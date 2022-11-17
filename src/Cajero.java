import java.io.Serializable;

public class Cajero implements ServicioBanco, Serializable {

    private Banco banco;// El banco asociado al cajero
    private VistaBanco vistaBanco;// La vista del banco

    /**
     * Constructor
     * 
     * @param banco El banco asociado al cajero
     */
    public Cajero(Banco banco) {
        this.banco = banco;
        this.vistaBanco = new VistaBanco(this);
    }

    /**
     * Método para crear una cuenta bancaria
     * 
     * @param beneficiario El nombre del beneficiario
     * @return La nueva cuenta creada
     */
    public CuentaBancaria crearCuenta(String beneficiario, String tipoCuenta) {

        return banco.crearCuenta(beneficiario, tipoCuenta);
    }

    /**
     * Método para consultar el saldo de una cuenta bancaria
     * 
     * @param numCuenta El número de cuenta del que se quiere consultar el saldo
     * @return El saldo de la cuenta solicitada, -1 si la cuenta no existe
     */
    @Override
    public double consultarSaldo(Long numCuenta) {
        return banco.consultarSaldo(numCuenta);
    }

    /**
     * Método para depositar dinero en una cuenta bancaria
     * 
     * @return boolean true si el depósito fue exitoso, false en otro caso
     */
    @Override
    public boolean depositar(Long numCuenta, double deposito) {
        return banco.depositar(numCuenta, deposito);
    }

    /**
     * Método para retirar dinero de una cuenta bancaria
     * boolean true si el retiro fue exitoso, false en otro caso
     */
    @Override
    public boolean retirar(Long numCuenta, int cvv, double retiro) {
        return banco.retirar(numCuenta, cvv, retiro);
    }

    /**
     * Método para comenzar con las funciones del banco con el usuario
     */
    public void mostrarMenu() {
        vistaBanco.menuPreguntasUsuario();
    }

    /**
     * Método para el recibir la respuesta del usuario en el menú principal
     * 
     * @param respuesta La respuesta del usuario
     */
    public void menuPreguntasUsuario(int respuesta) {
        switch (respuesta) {
            case 1:// registrarse
                registrarse();
                vistaBanco.salirAlMenuPrincipal();
                break;
            case 2:// consultar saldo
                consultarSaldo();
                vistaBanco.salirAlMenuPrincipal();
                break;
            case 3: // transferir dinero
                transferir();
                vistaBanco.salirAlMenuPrincipal();
                break;
            case 4:// Depositar
                depositar();
                vistaBanco.salirAlMenuPrincipal();
                break;
            case 5:// retirar
                retirar();
                vistaBanco.salirAlMenuPrincipal();
                break;
            default:// salir
                break;
        }

    }

    /**
     * Método para registrar a un nuevo usuario en el banco
     */
    private void registrarse() {
        String[] respuestas = vistaBanco.registrarse();// Obtenemos el arreglo. En [0] está el nombre de usuario, en [1]
                                                       // el tipo de cuenta
        // Se crea la cuenta
        CuentaBancaria nuevaCuenta = banco.crearCuenta(respuestas[0], respuestas[1]);
        // Se dan los datos de la nueva cuenta bancaria
        vistaBanco.registroExitoso(nuevaCuenta);
    }

    /**
     * Método para consultar el saldo de una cuenta
     */
    private void consultarSaldo() {
        // Pedimos el numero de cuenta bancaria al usuario
        Long numCuenta = vistaBanco.consultarSaldo();
        // Si la cuenta está registrada, se muestra el saldo disponible
        double saldoDisponible = banco.consultarSaldo(numCuenta);
        if (saldoDisponible != -1) {
            vistaBanco.mostrarSaldo(saldoDisponible);
        } else {
            vistaBanco.mostrarErrorNumCuenta();
        }
    }

    /**
     * Método para transferir dinero de una cuenta a otra
     */
    private void transferir() {
        // Obtenemos los numeros de cuenta de donde se retirará dinero
        Long numCuentaOrigen = vistaBanco.pedirNumCuenta(true);
        if (banco.existeCuenta(numCuentaOrigen)) {
            // Pedimos el cvv de la cuenta a la que se retirará dinero
            int cvvOrigen = vistaBanco.pedirCVV();
            if (banco.verificarCvv(cvvOrigen)) {
                Long numCuentaDestino = vistaBanco.pedirNumCuenta(false);
                if (banco.existeCuenta(numCuentaDestino)) {
                    // Obtenemos la cantidad a depositar del usuario
                    double transferencia = vistaBanco.pedirDineroOperacion(true);
                    vistaBanco.transferenciaExitosa(
                            banco.transferir(numCuentaOrigen, cvvOrigen, numCuentaDestino, transferencia));
                } else {
                    vistaBanco.mostrarErrorNumCuenta();
                }

            } else {
                vistaBanco.mostrarErrorCVV();
            }
            // Pedimos el número de cuenta a la que depositará

        } else {
            vistaBanco.mostrarErrorNumCuenta();
        }

    }

    /**
     * Método para depositar dinero en una cuenta bancaria
     */
    private void depositar() {
        // Pedimos el numero de cuenta y cantidad de deposito al usuario
        Long numCuentaUsuario = vistaBanco.pedirNumCuenta(true);
        if (banco.existeCuenta(numCuentaUsuario)) {
            double deposito = vistaBanco.pedirDineroOperacion(false);

            // Intentamos hacer el deposito
            boolean depositoExitoso = banco.depositar(numCuentaUsuario, deposito);
            vistaBanco.depositoExitoso(consultarSaldo(numCuentaUsuario), depositoExitoso);
        } else {
            vistaBanco.mostrarErrorNumCuenta();
        }
    }

    /**
     * Método para retirar dinero de una cuenta bancaria
     */
    private void retirar() {
        // Pedimos los datos de la cuenta al usuario
        Long numCuentaRetiro = vistaBanco.pedirNumCuenta(true);
        if (banco.existeCuenta(numCuentaRetiro)) {
            int cvv = vistaBanco.pedirCVV();
            if (banco.verificarCvv(cvv)) {
                double retiro = vistaBanco.retiro();
                // tratamos de hacer el retiro
                boolean retiroExitoso = banco.retirar(numCuentaRetiro, cvv, retiro);
                // Mostrams si el retiro fue o no exitoso
                vistaBanco.retiroExitoso(retiro, retiroExitoso);
            } else {
                vistaBanco.mostrarErrorCVV();
            }

        } else {
            vistaBanco.mostrarErrorNumCuenta();

        }

    }
}
