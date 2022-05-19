
public class BevegelsesTraad implements Runnable
{
    ModelSnake model;
    String retning;
    
    BevegelsesTraad(final ModelSnake model, String retning) {
        this.model = model;
        this.retning = retning;
    }
    
    @Override
    public void run() {
        for (int i = 0; i < 12; ++i) {
            for (int j = 0; j < 12; ++j) {
                if (this.model.controller.gui.hode.equals(this.model.controller.gui.grid[i][j]) 
                && this.model.controller.gui.grid[i][j].getText().compareTo("O")==0) {
                    this.model.sjekkOgSpisEple(this.model.controller.gui.grid[i][j]);
                }
            }
        }
        try {
            Thread.sleep(250);
        } catch (Exception e) {

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
            Thread.sleep(250);
        } catch (Exception e) {

        }
        run();
    }
}