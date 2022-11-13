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
        try {
            ObjectInputStream entrada = new ObjectInputStream(new FileInputStream("archivo.obj"));
            tienda = (Tienda) entrada.readObject();
            banco=tienda.getPayMe().getBanco();
            entrada.close();
        } catch (Exception e) {// Si el archivo no se pudo leer
            System.out.println("Iniciando...");
            banco=new Banco();
            PayMe payme=new PayMe(banco);
            
            CuentaBancaria cuenta=banco.crearCuenta("Inkspace", "premium");
            tienda=new Tienda(payme, cuenta.getNumCuenta());
            Admin admin=new Admin(tienda, "Ethan", "x23_?Ae");
            tienda.registrarAdmin(admin);
            System.out.println("se registro: "+tienda.getAdmin().getNombre()+" "+tienda.getAdmin().getContrasena());

        }

        if(args[0].equals("Banco")){
            Cajero cajero=new Cajero(banco);
            cajero.mostrarMenu();
        }else if(args[0].equals("Tienda")){
            Registro registro=new Registro(tienda);
            registro.menuOpciones();
        }else{
            System.out.println("No se ingresaron argumentos");
        }

        ObjectOutputStream escritor = null;
        try {
            escritor = new ObjectOutputStream(new FileOutputStream("archivo.obj"));
            escritor.writeObject(tienda);
        } catch (NotSerializableException e) {
            System.out.println("Error en la grabación: " + e + ". Objeto no serializable");
        } catch (IOException e) {
            System.out.println("Error en la grabación: " + e);
        } finally {
            if (escritor != null) {
                System.out.println("Cerrando el programa");
                try {
                    escritor.close();
                } catch (IOException e) {
                }
            } else {
                System.out.println("No se abrió ningún archivo");
            }
        }
    }
}
