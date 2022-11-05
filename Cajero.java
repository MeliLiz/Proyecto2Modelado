public class Cajero implements ServicioBanco {
    private Banco banco;
    private VistaBanco vistaBanco;

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
    public CuentaBancaria crearCuenta(String beneficiario) {
        return banco.crearCuenta(beneficiario);
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
}
