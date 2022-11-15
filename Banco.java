import java.io.Serializable;
import java.util.Hashtable;
import java.util.Random;
import java.util.Set;

/**
 * Clase que simula un banco
 */
public class Banco implements ServicioBanco, ConexionBancaria, Serializable{
    private Hashtable<Long, CuentaBancaria> cuentas;
    private FabricaCuentas fabricaCuentas;

    /**
     * Constructor del banco
     */
    public Banco() {
        cuentas = new Hashtable<Long, CuentaBancaria>();
        fabricaCuentas = new FabricaCuentas();
    }

    /**
     * Método para crear una cuenta bancaria
     * 
     * @param beneficiario El nombre del beneficiario
     * @return La nueva cuenta creada
     */
    public CuentaBancaria crearCuenta(String beneficiario, String tipoCuenta) {
        Random random = new Random();
        Long numCuenta = random.nextLong();
        if (numCuenta < 0) {
            numCuenta = numCuenta * -1;
        }
        //verificamos que no exista el numero de cuenta
        while (existeCuenta(numCuenta)) {
            numCuenta = random.nextLong();
            if (numCuenta < 0) {
                numCuenta = numCuenta * -1;
            }
        }
        //Obtenemos un cvv
        int cvv = random.nextInt(899) + 100;
        //Creamos la cuenta bancaria
        CuentaBancaria cuenta = fabricaCuentas.crearCuentaBancaria(tipoCuenta, numCuenta, beneficiario, cvv);
        cuentas.put(numCuenta, cuenta);//se registra la cuenta en el banco
        return cuenta;
    }

    /**
     * Método para consultar el saldo de una cuenta bancaria
     * 
     * @param numCuenta El número de cuenta del que se quiere consultar el saldo
     * @return El saldo de la cuenta solicitada, -1 si la cuenta no existe
     */
    public double consultarSaldo(Long numCuenta) {
        Set<Long> llaves = cuentas.keySet();

        for (Long llave : llaves) {
            if (llave.equals(numCuenta)) {
                return cuentas.get(llave).getSaldo();
            }
        }
        return -1;
    }

    /**
     * Método para depositar dinero en una cuenta bancaria
     * boolean true si el depósito fue exitoso, false en otro caso
     * 
     * @param numCuenta El número de cuenta a la que se depositará
     * @param deposito  La cantidad a depositar
     * @return boolean True si el depósito fue exitoso, false en otro caso
     */
    @Override
    public boolean depositar(Long numCuenta, double deposito) {
        Set<Long> llaves = cuentas.keySet();

        for (Long llave : llaves) {
            if (llave.equals(numCuenta)) {
                return cuentas.get(llave).depositar(deposito);
            }
        }
        return false;
    }

    /**
     * Método para retirar dinero de una cuenta bancaria
     * boolean true si el retiro fue exitoso, false en otro caso
     * 
     * @param numCuenta El número de cuenta a la que se retirará
     * @param cvv       El cvv de la cuenta a la que se retirará dinero
     * @param retiro    La cantidad a retirar
     * @return boolean True si el retiro fue exitoso, false en otro caso
     */
    @Override
    public boolean retirar(Long numCuenta, int cvv, double retiro) {
        if (verificarNumCuentaBancaria(numCuenta, cvv)) {

            return cuentas.get(numCuenta).retirar(retiro);

        }

        return false;
    }

    /**
     * M+etodo para transferir dinero de una cuenta bancaria a otra
     * 
     * @param numCuentaOrigen  El número de cuenta de la que se obtendrá el dinero
     * @param cvvOrigen        El cvv de la cuenta origen
     * @param numCuentaDestino El numero de cuenta que recibirá el dinero
     * @return boolean true si la transferencia fue exitosa, false en otro caso
     */
    @Override
    public boolean transferir(Long numCuentaOrigen, int cvvOrigen, Long numCuentaDestino, double cantidad) {
        //Verificamos que el número de cuenta origen coincida con su cvv y verificamos que la cuenta destino exista
        if (verificarNumCuentaBancaria(numCuentaOrigen, cvvOrigen) && existeCuenta(numCuentaDestino)) {
            //Verificamos que se pueda retirar la cantidad deseada de la cuenta origen
            if (retirar(numCuentaOrigen, cvvOrigen, cantidad)) {
                return cuentas.get(numCuentaDestino).depositar(cantidad);
            }
        }
        return false;
    }

    /**
     * Método para saber si un número de cuenta existe en el banco
     * 
     * @param cuenta El numero de cuenta a comprobar
     * @return boolean true si la cuenta existe, false en otro caso
     */
    @Override
    public boolean existeCuenta(Long cuenta) {
        Set<Long> llaves = cuentas.keySet();
        for (Long llave : llaves) {
            if (llave.equals(cuenta)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Método para verificar si corresponde el número de cuenta con el cvv
     * 
     * @param numCuenta El numero de cuenta a verificar
     * @param cvv       El cvv a verificar
     * @return boolean true si corresponde el numero de cuenta con el cvv, false en
     *         otro caso
     */
    private boolean verificarNumCuentaBancaria(Long numCuenta, int cvv) {
        Set<Long> llaves = cuentas.keySet();

        for (Long llave : llaves) {
            if (llave.equals(numCuenta)) {
                if (cuentas.get(llave).getCvv() != cvv) {
                    return false;
                }
                return true;
            }
        }
        return false;
    }

    /**
     * Método para obtener una cuenta dado su número de cuenta
     * 
     * @param numCuenta El número de cuenta que queremos obtener
     * @return La cuenta que queríamos obtener
     */
    public CuentaBancaria obtenerUnaCuenta(Long numCuenta) {
        if (existeCuenta(numCuenta)) {
            return cuentas.get(numCuenta);
        }
        return null;
    }

}
