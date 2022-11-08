public class FabricaCuentas {
    public CuentaBancaria crearCuentaBancaria(String tipoCuenta, long numCuenta, String beneficiario, int cvv){
        CuentaBancaria cuenta=null;
        if(tipoCuenta.equals("basica")){
            cuenta=new CuentaBasica(beneficiario, numCuenta, cvv, 0);
        }else if(tipoCuenta.equals("premium")){
            cuenta=new CuentaPremium(beneficiario, numCuenta, cvv, 0);
        }
        return cuenta;
    }
}
