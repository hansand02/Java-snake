import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ControllerSnake {
    
    ModelSnake backEnd;
    GUI gui;
    Thread aktivThread = null;
    public ArrayList<JLabel> rute = new ArrayList<>();

    ControllerSnake() {
        gui = new GUI(this);
        backEnd = new ModelSnake(this);
    }
    
    public void lagEple() {
        this.gui.lagEple();
    }
    public void lagKropp() {
        this.gui.lagKropp();
    }
    public void avsluttSpill() {
        gui.avsluttSpill();
        aktivThread.stop();
    }

    public void bevegVenstre() {
        if(aktivThread != null) {
            aktivThread.stop();
        }
        Thread t1 = new Thread(new BevegelsesTraad(backEnd, "venstre"));
        aktivThread = t1;
        t1.start();
            
    }
    public void bevegHoyre() {
        if(aktivThread != null) {
            aktivThread.stop();
        }
        Thread t1 = new Thread(new BevegelsesTraad(backEnd, "hoyre"));
        aktivThread = t1;
        t1.start();
        
    }
    public void bevegOpp() {
        if(aktivThread != null) {
            aktivThread.stop();
        }
        Thread t1 = new Thread(new BevegelsesTraad(backEnd, "opp"));
        aktivThread = t1;
        t1.start();
    }
    public void bevegNed() {
        if(aktivThread != null) {
            aktivThread.stop();
        }
        Thread t1 = new Thread(new BevegelsesTraad(backEnd, "ned"));
        aktivThread = t1;
        t1.start();
        
    }

}

