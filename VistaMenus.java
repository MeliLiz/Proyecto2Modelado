import java.util.Scanner;

public class VistaMenus {
    private TiendaUsuario tiendaUsuario;
    private Scanner scanner1=new Scanner(System.in);//Scanner para líneas
    private Scanner scanner2=new Scanner(System.in);//Scanner para números
    private Scanner scanner3=new Scanner(System.in);//Scanner para long

    public VistaMenus(TiendaUsuario tienda){
        tiendaUsuario=tienda;
    }

    public void bienvenida(){
        System.out.println("Bienvenid@ a InkSpace");
        int respuesta;
        while(true){
            System.out.println("Selecciona una opcion");
            System.out.println("1) Ver nuestra biblioteca de libros");
            System.out.println("2) Comprar un libro");
            System.out.println("3) Ir a tu biblioteca");
            System.out.println("4) Salir");
            try {
                respuesta=scanner2.nextInt();
                if(respuesta>1 && respuesta<5){
                    tiendaUsuario.menuOpciones(respuesta);
                    break;
                }else{
                    System.out.println("No ingresaste una opción válida");
                }
            } catch (Exception e) {
                System.out.println("No ingresaste un número");
            }
        }
        

    }
}
