import java.util.Hashtable;

/**
 * Clase que simula un banco
 */
public class Banco implements ServicioBanco{
    private Hashtable<Integer, CuentaBancaria> cuentas;

    public Banco(){
        cuentas=new Hashtable<Integer, CuentaBancaria>();
    }

    /**
     * Método para depositar dinero en una cuenta bancaria
     * boolean true si el depósito fue exitoso, false en otro caso
     */
    @Override
    public boolean depositar(int numCuenta) {
        // TODO Auto-generated method stub
        return false;
    }

    /**
     * Método para retirar dinero de una cuenta bancaria
     * boolean true si el retiro fue exitoso, false en otro caso
     */
    @Override
    public boolean retirar(int numCuenta, int cvv) {
        // TODO Auto-generated method stub
        return false;
    }

    /**
     * M+etodo para transferir dinero de una cuenta bancaria a otra
     * @param numCuentaOrigen El número de cuenta de la que se obtendrá el dinero
     * @param cvvOrigen El cvv de la cuenta origen
     * @param numCuentaDestino El numero de cuenta que recibirá el dinero
     * @return boolean true si la transferencia fue exitosa, false en otro caso
     */
    public boolean transferir(int numCuentaOrigen, int cvvOrigen, int numCuentaDestino){
        return true;
    }

    /**
     * Método para saber si un número de cuenta existe en el banco
     * @param cuenta El numero de cuenta a comprobar
     * @return boolean true si la cuenta existe, false en otro caso
     */
    private boolean existeCuenta(int cuenta){
        return true;
    }

    /**
     * Método para verificar si corresponde el número de cuenta con el cvv
     * @param numCuenta El numero de cuenta a verificar
     * @param cvv El cvv a verificar
     * @return boolean true si corresponde el numero de cuenta con el cvv, false en otro caso
     */
    private boolean verificarNumCuentaBancaria(int numCuenta, int cvv){
        return true;
    }
    
}
