import java.util.ArrayList;

public class TiendaUsuario {
    private Tienda tienda;
    private VistaMenus vistaMenus;
    private VistaTienda vistaTienda;
    private Usuario usuario;
    private Admin admin;
    private ArrayList<Libro> carrito;
    private String tipoUsuario;

    public TiendaUsuario(Tienda tienda, Usuario usuario, String tipoUsuario){
        this.tienda=tienda;
        vistaMenus=new VistaMenus(this);
        vistaTienda=new VistaTienda(this);
        this.usuario=usuario;
        carrito=new ArrayList<Libro>();
        this.tipoUsuario=tipoUsuario;
    }

    public TiendaUsuario(Tienda tienda, String tipoUsuario){
        this.tienda=tienda;
        vistaMenus=new VistaMenus(this);
        vistaTienda=new VistaTienda(this);
        this.tipoUsuario=tipoUsuario;
    }

    public void inicio(){
        vistaMenus.bienvenida();
    }

    public void menuOpciones(int respuesta){
        switch (respuesta) {
            case 1:
                mostrarCatalogo();
                break;
            case 2:
                comprar();
                break;
            case 3:
                irABiblioteca();
                break;
            case 4:
                salir();
                break;
        
            default:
                break;
        }
    }

    public void mostrarCatalogo(){

    }

    public void comprar(){

    }

    public void irABiblioteca(){

    }

    public void salir(){

    }

}
