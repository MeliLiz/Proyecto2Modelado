import java.io.Serializable;

/**
 * Clase que simula una cuenta bancaria premium
 * Este tipo de cuenta no tiene restricciones en depósitos ni retiros
 */
public class CuentaPremium extends CuentaBancaria implements Serializable{

    /**
     * Constructor
     * 
     * @param beneficiario El nombre del beneficiario
     * @param numCuenta    El numero de cuentaBancaria
     * @param cvv          el cvv
     * @param saldo        El saldo de la cuenta
     *
     */
    public CuentaPremium(String beneficiario, Long numCuenta, int cvv, double saldo) {
        super(beneficiario, numCuenta, cvv, saldo);
    }

    /**
     * Método para depositar dinero en la cuenta
     * 
     * @param cantidad La cantidad a depositar, debe ser una cantidad positiva
     * @return True si la operación fue exitosa, false en otro caso
     */
    @Override
    public boolean depositar(double cantidad) {
        if (cantidad < 0) {
            return false;
        }
        setSaldo(getSaldo() + cantidad);
        return true;
    }

    /**
     * Método para retirar dinero de la cuenta.
     * @param cantidad La cantidad a depositar, debe ser una cantidad positiva
     * @return boolean true si la operación fue exitosa, false en otro caso
     */
    @Override
    public boolean retirar(double cantidad) {
        if (cantidad < 0 || cantidad > getSaldo()) {
            return false;
        }
        setSaldo(getSaldo() - cantidad);
        return true;
    }

}
