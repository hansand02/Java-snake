// 
// Decompiled by Procyon v0.5.36
// 

public class BevegelsesTraad implements Runnable
{
    ModelSnake model;
    
    BevegelsesTraad(final ModelSnake model) {
        this.model = model;
    }
    
    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        }
        catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        this.model.bevegHoyre();
    }
}