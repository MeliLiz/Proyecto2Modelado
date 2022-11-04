/**
 * Clase para simular el sistema PayMe y poder conectar un negocio con el banco para recibir pagos a través de cuentas bancarias
 */
public class PayMe {
    private Banco banco;
    private double payMeCoins;

    /**
     * Método para saber si existe un número de cuenta registrado en el banco
     * @return boolean true si existe la cuenta, false en otro caso
     */
    public boolean existeCuenta(int numCuenta){
        return true;
    }

    /**
     * Método para tranferir dinero de una cuenta a otra
     * @return boolean true si la transferencia fue exitosa, false en otro caso
     */
    public boolean transferir(int numCuentaOrigen, int cvvOrigen, int numCuentaDestino){
        return true;
    }
}
