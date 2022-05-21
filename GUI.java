import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.event.KeyListener;
import javax.sound.sampled.Control;
import javax.swing.BorderFactory;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.UIManager;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.event.ActionListener;


public class GUI implements ActionListener 
{
    int poeng;
    JFrame frame;
    JPanel heleVinduet;
    JPanel spillBrett;
    JPanel kontrollPanel;
    JPanel statistikk;
    JPanel hoyreOgVenstre;
    JButton venstre;
    JButton hoyre;
    JButton opp;
    JButton ned;
    JLabel score;
    JLabel highScore;
    JLabel[][] grid;
    JLabel hode;
    ControllerSnake controller;
    KeyInput keyInput;
    
    GUI(final ControllerSnake controller) {
       
        this.frame = new JFrame("Slithery Snake SSSS");
        this.heleVinduet = new JPanel(new BorderLayout());
        this.spillBrett = new JPanel(new GridLayout(12, 12));
        this.kontrollPanel = new JPanel(new BorderLayout());
        this.statistikk = new JPanel();
        this.hoyreOgVenstre = new JPanel(new GridLayout(1, 0));
        this.venstre = new JButton("Venstre");
        this.hoyre = new JButton("Høyre");
        this.opp = new JButton("Opp");
        this.ned = new JButton("Ned");
        this.score = new JLabel("   Score: " + this.poeng, 2);
        this.grid = new JLabel[12][12];
        this.controller = controller;
        
        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        }
        catch (Exception ex) {}

        this.venstre.addActionListener(this);
        this.hoyre.addActionListener(this);
        this.opp.addActionListener(this);
        this.ned.addActionListener(this);
        frame.addKeyListener((KeyListener) (keyInput = new KeyInput(this.controller)));
        frame.setFocusable(true);
        frame.requestFocus();

        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setSize(new Dimension(600, 700));
        this.frame.add(this.heleVinduet);


        // FJERNET ALLE KNAPPER DA MAN KAN BRUKE TASTATURET NÅ
        /* this.kontrollPanel.setBackground(new Color(70, 120, 70));
        this.kontrollPanel.setOpaque(true);
        this.kontrollPanel.setPreferredSize(new Dimension(600, 150));
        this.kontrollPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 4));

        this.opp.setPreferredSize(new Dimension(0, 40));
        this.ned.setPreferredSize(new Dimension(0, 40));
        this.hoyreOgVenstre.add(this.venstre);
        this.hoyreOgVenstre.add(this.hoyre);
        this.kontrollPanel.add(this.opp, "North");
        this.kontrollPanel.add(this.ned, "South");
        this.kontrollPanel.add(this.hoyreOgVenstre, "Center"); */

        this.statistikk.setBackground(new Color(70, 120, 70));
        this.statistikk.setOpaque(true);
        this.statistikk.setPreferredSize(new Dimension(600, 100));
        this.statistikk.setBorder(BorderFactory.createLineBorder(Color.BLACK, 4));

        
        this.score.setFont(new Font("Serif", 1, 30));
        this.statistikk.add(this.score);

        for (int i = 0; i < 12; ++i) {
            for (int j = 0; j < 12; ++j) {
                final JLabel comp = new JLabel();
                comp.setSize(new Dimension(3, 3));
                comp.setBorder(BorderFactory.createLineBorder(Color.lightGray));
                comp.setOpaque(true);
                comp.setBackground(Color.white);
                this.grid[i][j] = comp;
                this.spillBrett.add(comp);
            }
        }
        this.heleVinduet.add(this.statistikk, "North");
        this.heleVinduet.add(this.spillBrett, "Center");
        this.heleVinduet.add(this.kontrollPanel, "South");
        (this.hode = this.grid[6][6]).setBackground(Color.green);
        this.hode.setOpaque(true);
        this.frame.setVisible(true);
    }
    
    @Override
    public void actionPerformed(final ActionEvent actionEvent) {
        if (actionEvent.getSource() == this.venstre) {
            this.controller.bevegVenstre();
        }
        else if (actionEvent.getSource() == this.hoyre) {
            this.controller.bevegHoyre();
        }
        else if (actionEvent.getSource() == this.opp) {
            this.controller.bevegOpp();
        }
        else if (actionEvent.getSource() == this.ned) {
            this.controller.bevegNed();
        }
    }
    
    public void avsluttSpill() {
        this.venstre.setEnabled(false);
        this.hoyre.setEnabled(false);
        this.opp.setEnabled(false);
        this.ned.setEnabled(false);
        keyInput = null;

        this.score.setText("Du tapte, prøv igjen");
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        frame.dispose();

    }

    public void lagEple() {
        int tall1 = (int)(Math.random()*(11+1));
        int tall2 = (int)(Math.random()*(11+1));
        grid[tall1][tall2].setText("O");
        grid[tall1][tall2].setFont(new Font("Ink Free", 1, 30));
        grid[tall1][tall2].setAlignmentX(JLabel.CENTER);
    }

    public void lagKropp() {
        for(JLabel ruter: this.controller.rute) {
            ruter.setBackground(Color.white);
        }
        if(controller.rute.size() > 0) {

            for(int i = 1; i< controller.backEnd.slangeLengde(); i++) {
                controller.rute.get(controller.rute.size()-(i)).setBackground(Color.orange);
            }
        }
    }
    
}
