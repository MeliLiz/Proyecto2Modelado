/**
 * Interfaz para el servicio de un banco
 */
public interface ServicioBanco {
    /**
     * Método para depositardinero en una cuenta de banco
     * @return
     */
    public boolean depositar(int numCuenta);

    /**
     * Método para retirar dinero de una cuenta de banco
     * @return
     */
    public boolean retirar(int numCuenta, int cvv);
}
