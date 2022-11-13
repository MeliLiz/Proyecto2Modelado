import java.io.Serializable;

/**
 * Clase para simular el sistema PayMe y poder conectar un negocio con el banco
 * para recibir pagos a través de cuentas bancarias
 */
public class PayMe implements Serializable{
    private Banco banco;

    /**
     * El constructor del sistema payme
     * @param banco El banco asociado al sistema payme
     */
    public PayMe(Banco banco) {
        this.banco = banco;
    }

    /**
     * Método para saber si existe un número de cuenta registrado en el banco
     * 
     * @return boolean true si existe la cuenta, false en otro caso
     */
    public boolean existeCuenta(Long numCuenta) {
        return banco.existeCuenta(numCuenta);
    }

    /**
     * Método para tranferir dinero de una cuenta a otra
     * 
     * @return boolean true si la transferencia fue exitosa, false en otro caso
     */
    public boolean transferir(Long numCuentaOrigen, int cvvOrigen, Long numCuentaDestino, double cantidad) {
        return banco.transferir(numCuentaOrigen, cvvOrigen, numCuentaDestino, cantidad);
    }

    /**
     * Método para obtener el banco asociado al Pay;E
     * @return Banco El banco asociado
     */
    public Banco getBanco(){
        return banco;
    }

}
