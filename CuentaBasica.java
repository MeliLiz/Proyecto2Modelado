public class CuentaBasica extends CuentaBancaria {
    private double limiteDeRetiro;
    private double limiteDeSaldo;

    /**
     * Constructor
     * 
     * @param beneficiario El nombre del beneficiario
     * @param numCuenta    El numero de cuentaBancaria
     * @param cvv          el cvv
     * @param saldo        El saldo de la cuenta
     */
    public CuentaBasica(String beneficiario, Long numCuenta, int cvv, double saldo) {
        super(beneficiario, numCuenta, cvv, saldo);
        this.limiteDeRetiro = 3000;
        this.limiteDeSaldo = 10000;
    }

    /**
     * Método para depositar dinero en la cuenta
     * 
     * @param cantidad La cantidad a depositar
     * @return True si la operación fue exitosa, false en otro caso
     */
    @Override
    public boolean depositar(double cantidad) {
        if (cantidad < 0 || (cantidad + getSaldo() > getLimiteDeSaldo())) {
            return false;
        }
        setSaldo(getSaldo() + cantidad);
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
     * Método para obtener el límite de saldo de la cuenta
     * 
     * @return El límite de saldo de la cuenta
     */
    public double getLimiteDeSaldo() {
        return this.limiteDeSaldo;
    }

    /**
     * Método para cambiar el límite de saldo de la cuenta
     * 
     * @param limiteDeSaldo El nuevo límite de saldo de la cuenta
     */
    public void setLimiteDeSaldo(double limiteDeSaldo) {
        this.limiteDeSaldo = limiteDeSaldo;
    }

}