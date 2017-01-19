import javax.swing.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 * Created by Dominik on 2017-01-19.
 */
public class SWD extends JFrame{
    private JSlider slider1;
    private JTextField textField1;
    private JButton wspomóżDecyzjęButton;
    private JLabel Komunikat;
    private JLabel RyzykoLabel;
    private JPanel rootPanel;

    public SWD() {
        slider1.addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                RyzykoLabel.setText(Integer.toString(slider1.getValue()) + '%');
            }
        });
    }
    public void init() {
        JFrame frame = new JFrame("SWD");
        frame.setContentPane(rootPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }



}
