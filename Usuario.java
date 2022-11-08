public class Usuario implements Observador{
    private String nombreUsuario;
    private String contrasena;
    private long cuentaBancaria;
    private Biblioteca biblioteca;
    private int numLibrosGratis=0;

    public Usuario(String usuario, String contrasena, long cuentaBancaria){
        nombreUsuario=usuario;
        this.contrasena=contrasena;
        this.cuentaBancaria=cuentaBancaria;
        biblioteca=new Biblioteca();
    }

    public Biblioteca getBiblioteca(){
        return biblioteca;
    }

    public String getNombreUsuario(){
        return nombreUsuario;
    }

    public String getContrasena(){
        return contrasena;
    }

    public int getNumLibrosGratis(){
        return numLibrosGratis;
    }

    @Override
    public void actualizar() {
        numLibrosGratis++;
    }
}
