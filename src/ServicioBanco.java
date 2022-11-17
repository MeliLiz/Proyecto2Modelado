/**
 * Interfaz para el servicio de un banco
 */
public interface ServicioBanco {

    /**
     * Método para crear una cuenta bancaria
     * 
     * @param beneficiario El nombre del beneficiario
     * @return La nueva cuenta creada
     */
    public CuentaBancaria crearCuenta(String beneficiario, String tipoCuenta);

    /**
     * Método para consultar el saldo de una cuenta bancaria
     * 
     * @param numCuenta El número de cuenta del que se quiere consultar el saldo
     * @return El saldo de la cuenta solicitada, -1 si la cuenta no existe
     */
    public double consultarSaldo(Long numCuenta);

    /**
     * Método para depositardinero en una cuenta de banco
     * 
     * @return
     */
    public boolean depositar(Long numCuenta, double deposito);

    /**
     * Método para retirar dinero de una cuenta de banco
     * 
     * @return
     */
    public boolean retirar(Long numCuenta, int cvv, double retiro);
}
