import java.util.ArrayList;
import javax.swing.*;

public class ControllerSnake {
    
    ModelSnake backEnd;
    GUI gui;
    Thread aktivThread = null;
    BevegelsesTraad aktivBevegelsesTraad = null;
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
            if (aktivBevegelsesTraad.retning().compareTo("hoyre") == 0) {
                return;
            }
            aktivThread.stop();
        }
        Thread t1 = new Thread(aktivBevegelsesTraad = new BevegelsesTraad(backEnd, "venstre"));
        aktivThread = t1;
        t1.start();
            
    }
    public void bevegHoyre() {
        if(aktivThread != null) {
            if (aktivBevegelsesTraad.retning().compareTo("venstre") == 0) {
                return;
            }
            aktivThread.stop();
        }
        Thread t1 = new Thread(aktivBevegelsesTraad = new BevegelsesTraad(backEnd, "hoyre"));
        aktivThread = t1;
        t1.start();
        
    }
    public void bevegOpp() {
        if(aktivThread != null) {
            if (aktivBevegelsesTraad.retning().compareTo("ned") == 0) {
                return;
            }
            aktivThread.stop();
        }
        Thread t1 = new Thread(aktivBevegelsesTraad = new BevegelsesTraad(backEnd, "opp"));
        aktivThread = t1;
        t1.start();
    }
    public void bevegNed() {
        if(aktivThread != null) {
            if (aktivBevegelsesTraad.retning().compareTo("opp") == 0) {
                return;
            }
            aktivThread.stop();
        }
        Thread t1 = new Thread(aktivBevegelsesTraad = new BevegelsesTraad(backEnd, "ned"));
        aktivThread = t1;
        t1.start();
        
    }

}

