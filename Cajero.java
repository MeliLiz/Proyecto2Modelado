public class Cajero implements ServicioBanco {

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
    public double consultarSaldo(long numCuenta) {
        return banco.consultarSaldo(numCuenta);
    }

    /**
     * Método para depositar dinero en una cuenta bancaria
     * 
     * @return boolean true si el depósito fue exitoso, false en otro caso
     */
    @Override
    public boolean depositar(long numCuenta, double deposito) {
        return banco.depositar(numCuenta, deposito);
    }

    /**
     * Método para retirar dinero de una cuenta bancaria
     * boolean true si el retiro fue exitoso, false en otro caso
     */
    @Override
    public boolean retirar(long numCuenta, int cvv, double retiro) {
        return banco.retirar(numCuenta, cvv, retiro);
    }

    /**
     * Método para el recibir la respuesta del usuario en el menú principal
     * 
     * @param respuesta La respuesta del usuario
     */
    public void menuPreguntasUsuario(int respuesta) {
        switch (respuesta) {
            case 1:
                String[] respuestas = vistaBanco.registrarse();
                CuentaBancaria nuevaCuenta = banco.crearCuenta(respuestas[0], respuestas[1]);
                vistaBanco.registroExitoso(nuevaCuenta);

                break;
            case 2:
                long numCuenta = vistaBanco.consultarSaldo();

                if (banco.existeCuenta(numCuenta)) {
                    vistaBanco.mostrarSaldo(banco.consultarSaldo(numCuenta), banco.existeCuenta(numCuenta));

                }

                break;
            case 3:
                double transferencia = vistaBanco.pedirDineroOperacion(true);
                long numCuentaOrigen = vistaBanco.pedirNumCuenta(true);
                long numCuentaDestino = vistaBanco.pedirNumCuenta(false);
                int cvvOrigen = vistaBanco.pedirCVV();
                vistaBanco.transferenciaExitosa(
                        banco.transferir(numCuentaOrigen, cvvOrigen, numCuentaDestino, transferencia));
                break;
            case 4:
                long numCuentaUsuario = vistaBanco.pedirNumCuenta(true);

                if (banco.existeCuenta(numCuentaUsuario)) {
                    double deposito = vistaBanco.pedirDineroOperacion(false);
                    boolean depositoExitoso = banco.depositar(numCuentaUsuario, deposito);
                    vistaBanco.depositoExitoso(numCuentaUsuario, depositoExitoso);

                } else {
                    vistaBanco.mostrarErrorNumCuenta();
                }
                break;
            case 5:
                long numCuentaRetiro = vistaBanco.pedirNumCuenta(true);
                if (banco.existeCuenta(numCuentaRetiro)) {
                    double retiro = vistaBanco.retiro();
                    int cvv = vistaBanco.pedirCVV();
                    boolean retiroExitoso = banco.retirar(numCuentaRetiro, cvv, retiro);
                    vistaBanco.retiroExitoso(retiro, retiroExitoso);

                } else {
                    vistaBanco.mostrarErrorNumCuenta();
                }

                break;
            case 0:
                vistaBanco.salirAlMenuPrincipal();
                break;
            default:
                break;
        }
    }
}
