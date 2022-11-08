/**
 * Clase de una cuenta básica
 * Esta cuenta tiene un límite de retiro y cobra un interés al depositar más de
 * una cantidad determinada
 */
public class CuentaBasica extends CuentaBancaria {
    private double limiteDeRetiro;
    private double interesDeposito;
    private double pivoteInteres;// la cantidad de depósito a partir de la cual se cobra el interés

    /**
     * Constructor
     * 
     * @param beneficiario El nombre del beneficiario
     * @param numCuenta    El numero de cuentaBancaria
     * @param cvv          El cvv de la cuenta bancaria, es con lo que se verifica
     *                     la cuenta
     * @param saldo        El saldo de la cuenta
     */
    public CuentaBasica(String beneficiario, Long numCuenta, int cvv, double saldo) {
        super(beneficiario, numCuenta, cvv, saldo);
        limiteDeRetiro = 3000;
        interesDeposito = 0.03;
        pivoteInteres = 2000;
    }

    /**
     * Método para depositar dinero en la cuenta. Esta cuenta cobra el 3% del
     * depósito si la cantidad a depositar es mayor a $2000
     * 
     * @param cantidad La cantidad a depositar
     * @return True si la operación fue exitosa, false en otro caso
     */
    @Override
    public boolean depositar(double cantidad) {
        if (cantidad < 0) {
            return false;
        } else if (cantidad > pivoteInteres) {
            setSaldo(cantidad - (interesDeposito * cantidad));
        } else {
            setSaldo(getSaldo() + cantidad);
        }
        return true;
    }

    /**
     * Método para retirar dinero de la cuenta
     * 
     * @param cantidad
     * @return True si la operacion fue exitosa, false en otro caso
     */
    @Override
    public boolean retirar(double cantidad) {
        if (cantidad < 0 || (cantidad > getLimiteDeRetiro()) || cantidad > getSaldo()) {
            return false;
        }
        setSaldo(getSaldo() - cantidad);
        return true;
    }

    /**
     * Método para obtener el límite de retiro de la cuenta
     * 
     * @return El límite de retiro de la cuenta
     */
    public double getLimiteDeRetiro() {
        return this.limiteDeRetiro;
    }

    /**
     * Método para cambiar el límite de retiro de la cuenta
     * 
     * @param limiteDeRetiro El nuevo límite de retiro de la cuenta
     */
    public void setLimiteDeRetiro(double limiteDeRetiro) {
        this.limiteDeRetiro = limiteDeRetiro;
    }

    /**
     * Método para obtener el interés que se cobra al depositar más de la cantidad
     * de pivoteInteres
     * 
     * @return double El interés del depósito
     */
    public double getInteresDeposito() {
        return this.interesDeposito;
    }

    /**
     * Método para cambiar la cantidad de interés que se cobrará al depositar más de
     * la cantidad del pivoteInteres
     * 
     * @param interesDeposito La cantidad de interés
     */
    public void setInteresDeposito(double interesDeposito) {
        this.interesDeposito = interesDeposito;
    }

    /**
     * Método para obtener la cantidad de depósito a partir de la cual se cobrará el
     * interés
     * 
     * @return double la cantidad a partir de la cual se cobra el inteŕes del
     *         depósito
     */
    public double getPivoteInteres() {
        return pivoteInteres;
    }

    /**
     * Método para cambiar la cantidad de depósito a partir de la cual se cobrará el
     * interés
     * 
     * @param pivoteInteres La cantidad a partir de la cual se cobra el inteŕes del
     *                      depósito
     */
    public void setPivoteInteres(double pivoteInteres) {
        this.pivoteInteres = pivoteInteres;
    }

}
