public class Main {
    public static void main(String[] args) {
        Banco banco=new Banco();
        Cajero cajero=new Cajero(banco);
        CuentaBancaria cuenta=cajero.crearCuenta("meli", "premium");
        System.out.println(cuenta.getCvv());
        System.out.println(cuenta.getNumCuenta());
        PayMe payme=new PayMe(banco);
        Tienda tienda=new Tienda(payme);
        Registro registro=new Registro(tienda);
        registro.menuOpciones();
    }
}
