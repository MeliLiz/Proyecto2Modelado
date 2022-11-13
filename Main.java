import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.NotSerializableException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Main {

    public static void main(String[] args) {

        Tienda tienda;
        Banco banco;
        VistaMain vistaMain = new VistaMain();
        try {
            ObjectInputStream entrada = new ObjectInputStream(new FileInputStream("archivo.obj"));
            tienda = (Tienda) entrada.readObject();
            banco = tienda.getPayMe().getBanco();
            entrada.close();
        } catch (Exception e) {// Si el archivo no se pudo leer
            vistaMain.iniciar();
            banco = new Banco();
            PayMe payme = new PayMe(banco);

            CuentaBancaria cuenta = banco.crearCuenta("Inkspace", "premium");
            tienda = new Tienda(payme, cuenta.getNumCuenta());
            Admin admin = new Admin(tienda, "Ethan", "x23_?Ae");
            tienda.registrarAdmin(admin);

        }

        if (args[0].equals("Banco")) {
            Cajero cajero = new Cajero(banco);
            cajero.mostrarMenu();
        } else if (args[0].equals("Tienda")) {
            Registro registro = new Registro(tienda);
            registro.menuOpciones();
        } else {
            vistaMain.errorArgumentos();
        }

        ObjectOutputStream escritor = null;
        try {
            escritor = new ObjectOutputStream(new FileOutputStream("archivo.obj"));
            escritor.writeObject(tienda);
        } catch (NotSerializableException e) {
            vistaMain.errorEnSerializar(e);
        } catch (IOException e) {
            vistaMain.errorEnIO(e);
        } finally {
            if (escritor != null) {
                vistaMain.cerrarPrograma();
                try {
                    escritor.close();
                } catch (IOException e) {
                }
            } else {
                vistaMain.noSeAbrioArchivo();
            }
        }
    }
}
