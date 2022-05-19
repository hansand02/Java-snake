
public class ControllerSnake {
    
    ModelSnake backEnd;
    GUI gui;

    ControllerSnake() {
        gui = new GUI(this);
        backEnd = new ModelSnake(this);
    }
    

    public void bevegVenstre() {
        for(int i=0; i< 12 ; i++) {
            Thread t1 = new Thread(new BevegelsesTraad(backEnd));
            t1.start();
            
        }
        
    }
    public void bevegHoyre() {
        for(int i=0; i< 12 ; i++) {
            Thread t1 = new Thread(new BevegelsesTraad(backEnd));
            t1.start();
            
        }
        
    }
    public void bevegOpp() {
        for(int i=0; i< 12 ; i++) {
            Thread t1 = new Thread(new BevegelsesTraad(backEnd));
            t1.start();
            
        }
    }
    public void bevegNed() {
        for(int i=0; i< 12 ; i++) {
            Thread t1 = new Thread(new BevegelsesTraad(backEnd));
            t1.start();
        }
        
    }

}

