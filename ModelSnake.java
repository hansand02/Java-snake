import java.awt.Color;



public class ModelSnake
{
    ControllerSnake controller;
    
    ModelSnake(final ControllerSnake controller) {
        this.controller = controller;
    }
    
    public void lagEple() {
    }
    
    public boolean sjekkKollisjon() {
        return false;
    }
    
    public int slangeLengde() {
        return 5;
    }
    
    public void leggTilLengde() {
    }
    
    public void startSpill() {
        this.controller.gui.hode.setBackground(Color.green);
    }
    
    public void bevegVenstre() {
        for (int i = 0; i < 12; ++i) {
            for (int j = 0; j < 12; ++j) {
                if (this.controller.gui.hode.equals(this.controller.gui.grid[i][j]) && j <= 11 && i <= 11 && j >= 0 && i >= 0) {
                    if (j > 0) {
                        final GUI gui = this.controller.gui;
                        ++gui.poeng;
                        this.controller.gui.score.setText("   Score: " + this.controller.gui.poeng);
                        this.controller.gui.hode.setBackground(Color.white);
                        (this.controller.gui.hode = this.controller.gui.grid[i][j - 1]).setBackground(Color.green);
                        this.controller.gui.hode.setOpaque(true);
                    }
                    else if (j == 0) {
                        this.controller.gui.avsluttSpill();
                    }
                    return;
                }
            }
        }
    }
    
    public void bevegHoyre() {
        for (int i = 0; i < 12; ++i) {
            for (int j = 0; j < 12; ++j) {
                if (this.controller.gui.hode.equals(this.controller.gui.grid[i][j]) && j <= 11 && i <= 11 && j >= 0 && i >= 0) {
                    if (j < 11) {
                        final GUI gui = this.controller.gui;
                        ++gui.poeng;
                        this.controller.gui.score.setText("   Score: " + this.controller.gui.poeng);
                        this.controller.gui.hode.setBackground(Color.white);
                        (this.controller.gui.hode = this.controller.gui.grid[i][j + 1]).setBackground(Color.green);
                        this.controller.gui.hode.setOpaque(true);
                    }
                    else if (j == 11) {
                        this.controller.gui.avsluttSpill();
                    }
                    return;
                }
            }
        }
    }
    
    public void bevegOpp() {
        for (int i = 0; i < 12; ++i) {
            for (int j = 0; j < 12; ++j) {
                if (this.controller.gui.hode.equals(this.controller.gui.grid[i][j]) && j <= 11 && i <= 11 && j >= 0 && i >= 0) {
                    if (i > 0) {
                        final GUI gui = this.controller.gui;
                        ++gui.poeng;
                        this.controller.gui.score.setText("   Score: " + this.controller.gui.poeng);
                        this.controller.gui.hode.setBackground(Color.white);
                        (this.controller.gui.hode = this.controller.gui.grid[i - 1][j]).setBackground(Color.green);
                        this.controller.gui.hode.setOpaque(true);
                    }
                    else if (i == 0) {
                        this.controller.gui.avsluttSpill();
                    }
                    return;
                }
            }
        }
    }
    
    public void bevegNed() {
        for (int i = 0; i < 12; ++i) {
            for (int j = 0; j < 12; ++j) {
                if (this.controller.gui.hode.equals(this.controller.gui.grid[i][j]) && j <= 11 && i < 11 && j >= 0 && i >= 0) {
                    if (j < 11) {
                        final GUI gui = this.controller.gui;
                        ++gui.poeng;
                        this.controller.gui.score.setText("   Score: " + this.controller.gui.poeng);
                        this.controller.gui.hode.setBackground(Color.white);
                        (this.controller.gui.hode = this.controller.gui.grid[i + 1][j]).setBackground(Color.green);
                        this.controller.gui.hode.setOpaque(true);
                    }
                    else if (j == 11) {
                        this.controller.gui.avsluttSpill();
                    }
                    return;
                }
            }
        }
    }
}