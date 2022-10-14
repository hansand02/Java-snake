
public class BevegelsesTraad implements Runnable
{
    ModelSnake model;
    String retning;
    private Boolean notStopped = true;
    
    BevegelsesTraad(final ModelSnake model, String retning) {
        this.model = model;
        this.retning = retning;
    }

    public String retning() {
        return retning;
    }
    
    public void stopThread() {
        notStopped = false;
        retning = "null";
    }

    @Override
    public void run() {
        for (int i = 0; i < 12; ++i) {
            for (int j = 0; j < 12; ++j) {
                if (this.model.controller.gui.hode.equals(this.model.controller.gui.grid[i][j]) 
                && this.model.controller.gui.grid[i][j].getIcon() != null) {
                    this.model.sjekkOgSpisEple(this.model.controller.gui.grid[i][j]);
                }
            }
        }
       
        
        if(retning.compareTo("hoyre") == 0 ) {
            this.model.bevegHoyre();
        }
        else if(retning.compareTo("venstre") == 0 ) {
            this.model.bevegVenstre();
        }
        else if(retning.compareTo("opp") == 0 ) {
            this.model.bevegOpp();
        }
        else if(retning.compareTo("ned") == 0 ) {
            this.model.bevegNed();
        }
        try {

            //80 er sleeptiden slangen ender paa, 380 blir tiden ved lengde = 1
            Thread.sleep(
            (300+80*model.slangeLengde())/(model.slangeLengde())
            ); 


        } catch (Exception e) {
            
        }
        if(notStopped) {
            run();
        }
        
    }


}