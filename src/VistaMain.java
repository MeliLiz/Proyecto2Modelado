import java.io.IOException;
import java.io.NotSerializableException;

/**
 * Clase vista para el main
 */
public class VistaMain {
    public static final String RESET = "\033[0m"; // para resetear el color en la terminal
    public static final String ROJO = "\033[0;31m"; // para mensajes de error en la terminal
    public static final String CYAN = "\033[0;36m"; // color Cyan para los menus

    /**
     * Metodo para iniciar el programa en el main
     */
    public void iniciar() {
        System.out.println(CYAN + "<<<Iniciando Programa>>>\n" + RESET);
    }

    /**
     * Método para mostrar error cuando no se escriban argumentos a la hora de
     * ejecutar el programa
     */
    public void errorArgumentos() {
        System.out.println(ROJO + "Error, no se ingresaron argumentos a la hora de ejecutar el programa" + RESET);
    }

    /**
     * Método para mostrar un error en el momento de serializar
     * 
     * @param e Una exception de tipo NotSerializableException
     */
    public void errorEnSerializar(NotSerializableException e) {
        System.out.println(ROJO + "Error en la grabación: " + e + ". Objeto no serializable\n" + RESET);
    }

    /**
     * Método para mostrar un error en la entrada o salida de un archivo
     * 
     * @param e Una exception de tipo IOException
     */
    public void errorEnIO(IOException e) {
        System.out.println(ROJO + "Error en la grabación: " + e + RESET + "\n");
    }

    /**
     * Método para mostrar que se está cerrando el programa
     */
    public void cerrarPrograma() {
        System.out.println(CYAN + "\nCerrando Programa...\n" + RESET);
    }

    /**
     * Método que muestra que no se abrió ningun archivo al leer uno
     */
    public void noSeAbrioArchivo() {
        System.out.println(ROJO + "No se abrió ningun archivo\n" + RESET);
    }

}
