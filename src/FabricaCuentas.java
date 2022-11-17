import java.io.Serializable;

/**
 * Clase para crear una cuenta bancaria dependiendo de su tipo
 */
public class FabricaCuentas implements Serializable{
    
    /**
     * Constructor de una cuenta bancaria
     * @param tipoCuenta Tipo de cuenta "básica" o "premium"
     * @param numCuenta El número de cuenta que tendrá la cuenta
     * @param beneficiario El nombre del dueño de la cuenta
     * @param cvv El cvv de la cuenta bancaria
     * @return CuentaBancaria La nueva cuenta dependiendo de su tipo
     */
    public CuentaBancaria crearCuentaBancaria(String tipoCuenta, Long numCuenta, String beneficiario, int cvv){
        CuentaBancaria cuenta=null;
        if(tipoCuenta.equals("basica")){
            cuenta=new CuentaBasica(beneficiario, numCuenta, cvv, 0);
        }else if(tipoCuenta.equals("premium")){
            cuenta=new CuentaPremium(beneficiario, numCuenta, cvv, 0);
        }
        return cuenta;
    }
}
