import claseBaza.ManagerCursuri;

public class Main {
    public static void main(String[] args) {

        consoleThread consola=new consoleThread();
        guiThread gui=new guiThread();
        ManagerCursuri manager=new ManagerCursuri();


        consola.start();
        gui.start();

    }
}