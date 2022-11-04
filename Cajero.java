public class Cajero implements ServicioBanco{
    private Banco banco;
    private VistaBanco vistaBanco;

    /**
     * Método para depositar dinero en una cuenta bancaria
     * @return boolean true si el depósito fue  exitoso, false en otro caso
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
}
