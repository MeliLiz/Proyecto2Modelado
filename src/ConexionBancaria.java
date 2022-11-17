/**
 * Interfaz con los métodos que debe tener la conexion al banco y el banco
 */
public interface ConexionBancaria {
    /**
     * Método para saber si existe un número de cuenta registrado en el banco
     * 
     * @return boolean true si existe la cuenta, false en otro caso
     */
    public boolean existeCuenta(Long cuenta);

    /**
     * M+etodo para transferir dinero de una cuenta bancaria a otra
     * 
     * @param numCuentaOrigen  El número de cuenta de la que se obtendrá el dinero
     * @param cvvOrigen        El cvv de la cuenta origen
     * @param numCuentaDestino El numero de cuenta que recibirá el dinero
     * @return boolean true si la transferencia fue exitosa, false en otro caso
     */
    public boolean transferir(Long numCuentaOrigen, int cvvOrigen, Long numCuentaDestino, double cantidad);
}
