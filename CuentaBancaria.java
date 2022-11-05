/**
 * Clase para representar una cuenta bancaria
 */
public abstract class CuentaBancaria {
    private String beneficiario;
    private Long numCuenta;
    private int cvv;
    private double saldo;

    /**
     * Constructor
     * 
     * @param beneficiario El nombre del beneficiario
     * @param numCuenta    El numero de cuentaBancaria
     * @param cvv          el cvv
     * @param saldo        El saldo de la cuenta
     *
     */
    public CuentaBancaria(String beneficiario, Long numCuenta, int cvv, double saldo) {
        this.beneficiario = beneficiario;
        this.numCuenta = numCuenta;
        this.cvv = cvv;
        this.saldo = saldo;
    }

    /**
     * Método para depositar dinero en la cuenta
     * 
     * @param cantidad La cantidad a depositar
     * @return True si la operación fue exitosa, false en otro caso
     */
    public abstract boolean depositar(double cantidad);

    /**
     * Método para retirar dinero de la cuenta
     * 
     * @param cantidad
     * @return True si la operacion fue exitosa, false en otro caso
     */
    public abstract boolean retirar(double cantidad);

    /**
     * Método para obtener el nombre del beneficiario
     * 
     * @return El nombre del beneficiario
     */
    public String getBeneficiario() {
        return this.beneficiario;
    }

    /**
     * Método para cambiar el nombre del beneficiario
     * 
     * @param beneficiario El nuevo nombre del beneficiario
     */
    public void setBeneficiario(String beneficiario) {
        this.beneficiario = beneficiario;
    }

    /**
     * Método para obtener el número de cuenta
     * 
     * @return El número de cuenta
     */
    public Long getNumCuenta() {
        return this.numCuenta;
    }

    /**
     * Método para cambair el número de cuenta
     * 
     * @param numCuenta EL nuevo número de cuenta
     */
    public void setNumCuenta(Long numCuenta) {
        this.numCuenta = numCuenta;
    }

    /**
     * Método para obtener el cvv
     * 
     * @return El cvv
     */
    public int getCvv() {
        return this.cvv;
    }

    /**
     * Método para cambiar el cvv
     * 
     * @param cvv El nuevo cvv
     */
    public void setCvv(int cvv) {
        this.cvv = cvv;
    }

    /**
     * Método para obtener el saldo de la cuenta
     * 
     * @return El saldo de la cuenta
     */
    public double getSaldo() {
        return this.saldo;
    }

    /**
     * Método para cambiar el saldo de la cuenta
     * 
     * @param saldo El nuevo saldo de la cuenta
     */
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    @Override
    public String toString() {
        return "Nombre del beneficierio: " + this.beneficiario + "\n" +
                "Número de cuenta: " + this.numCuenta + "\n" +
                "Cvv: " + this.cvv + "\n" +
                "Saldo: " + this.saldo + "\n";
    }

}
