import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JFrame;

public class PanelExample
{
    PanelExample() {
        final JFrame frame = new JFrame("Panel Example");
        final JPanel comp = new JPanel();
        comp.setBounds(40, 80, 200, 200);
        comp.setBackground(Color.gray);
        final JButton comp2 = new JButton("Button 1");
        comp2.setBounds(50, 100, 80, 30);
        comp2.setBackground(Color.yellow);
        final JButton comp3 = new JButton("Button 2");
        comp3.setBounds(100, 100, 80, 30);
        comp3.setBackground(Color.green);
        comp.add(comp2);
        comp.add(comp3);
        frame.add(comp);
        frame.setSize(400, 400);
        frame.setLayout(null);
        frame.setVisible(true);
    }
    
    public static void main(final String[] array) {
        new PanelExample();
    }
}