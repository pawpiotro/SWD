import javax.swing.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 * Created by Dominik on 2017-01-19.
 */
public class SWD {
    private JSlider slider1;
    private JTextField textField1;
    private JButton wspomóżDecyzjęButton;
    private JLabel Komunikat;
    private JLabel RyzykoLabel;

    public SWD() {
        slider1.addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                RyzykoLabel.setText(Integer.toString(slider1.getValue()) + '%');
            }
        });

        JFrame frame = new JFrame("SWD");
        frame.setContentPane(this.contentPane);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }


}
