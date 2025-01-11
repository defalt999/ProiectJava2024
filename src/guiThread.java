import guiForms.authenticate;

import javax.swing.*;

public class guiThread extends Thread {
    @Override
    public void run() {
        SwingUtilities.invokeLater(() -> {
            createAndShowGUI();         //Cod de pe net nu stiu ce face invokeLater
        });

    }

    private void createAndShowGUI() {
        authenticate auth = new authenticate();

    }
}
