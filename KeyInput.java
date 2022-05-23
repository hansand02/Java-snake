import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

class KeyInput extends KeyAdapter {
    ControllerSnake controller;
    KeyInput(ControllerSnake controller2) {
        controller = controller2;
    }

    public void keyPressed(KeyEvent e) {
        controller.gui.frame.removeKeyListener(controller.gui.keyInput);
        int keyCode = e.getKeyCode();
        if (keyCode == KeyEvent.VK_UP) {
            controller.bevegOpp();
        }
        else if (keyCode == KeyEvent.VK_DOWN) {
            controller.bevegNed();
        }
        else if (keyCode == KeyEvent.VK_LEFT) {
            controller.bevegVenstre();
        }
        else if (keyCode == KeyEvent.VK_RIGHT) {
            controller.bevegHoyre();
        }
     
        controller.gui.frame.addKeyListener(controller.gui.keyInput);
    }
}