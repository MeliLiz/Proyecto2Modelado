/**
 * Clase para representar una cuenta bancaria
 */
public class CuentaBancaria {
    private String beneficiario;
    private int numCuenta;
    private int cvv;
    private double saldo;

    /**
     * Constructor
     * @param beneficiario El nombre del beneficiario
     */
    public CuentaBancaria(String beneficiario){

    }

    /**
     * Método para depositar dinero en la cuenta
     * @param cantidad La cantidad a depositar
     * @return
     */
    public boolean depositar(double cantidad){
        return true;
    }

    /**
     * Método para retirar dinero de la cuenta
     * @param cantidad
     * @return
     */
    public boolean retirar(int cantidad){
        return true;
    }
}
