import java.awt.Color;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class ModelSnake
{
    ControllerSnake controller;
    private int lengde = 1;
    
    ModelSnake(final ControllerSnake controller) {
        this.controller = controller;
        this.controller.lagFoersteEple();
    }
    
    

    public void sjekkOgSpisEple(JLabel label) {
        if(label.getIcon().getIconHeight() == 46) {
            lengde += 3;
            label.setIcon(null);
            this.controller.gui.score.setText("Keegt");
            return;
        }
        label.setIcon(null);
        lengde++;
        this.controller.gui.score.setText("   Score: " + (this.controller.backEnd.slangeLengde()-1));
        this.controller.lagEple();
        
        
    }
    
    public int slangeLengde() {
        return lengde;
    }
    public void resettSlange() {
        lengde = 1;
    }
    
    public void bevegVenstre() {
        for (int i = 0; i < 12; ++i) {
            for (int j = 0; j < 12; ++j) {
                if (this.controller.gui.hode.equals(this.controller.gui.grid[i][j]) && j <= 11 && i <= 11 && j >= 0 && i >= 0) {
                    if (j > 0) {           
                        this.controller.gui.hode.setBackground(Color.white);
                        this.controller.lagKropp();
                        if(this.controller.gui.grid[i][j - 1].getBackground() == Color.orange) {
                            controller.avsluttSpill();
                        }
                        (this.controller.gui.hode = this.controller.gui.grid[i][j - 1]).setBackground(Color.green);
                        this.controller.gui.hode.setOpaque(true);
                        this.controller.rute.add(this.controller.gui.hode);
                    }
                    else if (j == 0) {
                        this.controller.avsluttSpill();
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
                        this.controller.gui.hode.setBackground(Color.white);
                        this.controller.lagKropp();
                        if(this.controller.gui.grid[i][j + 1].getBackground() == Color.orange) {
                            controller.avsluttSpill();
                        }
                        (this.controller.gui.hode = this.controller.gui.grid[i][j + 1]).setBackground(Color.green);
                        this.controller.gui.hode.setOpaque(true);
                        this.controller.rute.add(this.controller.gui.hode);
                    }
                    else if (j == 11) {
                        this.controller.avsluttSpill();
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
                        this.controller.gui.hode.setBackground(Color.white);
                        this.controller.lagKropp();
                        if(this.controller.gui.grid[i-1][j].getBackground() == Color.orange) {
                            controller.avsluttSpill();
                        }
                        (this.controller.gui.hode = this.controller.gui.grid[i - 1][j]).setBackground(Color.green);
                        this.controller.gui.hode.setOpaque(true);
                        this.controller.rute.add(this.controller.gui.hode);
                    }
                    else if (i == 0) {
                        this.controller.avsluttSpill();
                    }
                    return;
                }
            }
        }
    }
    
    public void bevegNed() {
        for (int i = 0; i < 12; ++i) {
            for (int j = 0; j < 12; ++j) {
                if (this.controller.gui.hode.equals(this.controller.gui.grid[i][j]) && j <= 11 && i <= 11 && j >= 0 && i >= 0) {
                    if (i < 11) {
                        this.controller.gui.hode.setBackground(Color.white);
                        this.controller.lagKropp();
                        if(this.controller.gui.grid[i+1][j].getBackground() == Color.orange) {
                            controller.avsluttSpill();
                        }
                        (this.controller.gui.hode = this.controller.gui.grid[i + 1][j]).setBackground(Color.green);
                        this.controller.gui.hode.setOpaque(true);
                        this.controller.rute.add(this.controller.gui.hode);
                    }
                    else if (i == 11) {
                        this.controller.avsluttSpill();
                    }
                    return;
                }
            }
        }
    }
}
