import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Dominik on 2017-01-19.
 */
public class SWD {
    private JSlider RyzykoInput;
    private JButton WDButton;
    private JLabel Komunikat;
    private JLabel RyzykoLabel;
    private JPanel panel;
    private JLabel LabelRyzyko;
    private JLabel LabelSrodki;
    private JSpinner FundInput;

    public SWD() {

        JFrame frame = new JFrame("SWD");
        frame.setContentPane(this.panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        RyzykoInput.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                RyzykoLabel.setText(Integer.toString(RyzykoInput.getValue()) + '%');
            }
        });
    }

    public void addWDButtonListener(ActionListener listenerForWDButton){
        WDButton.addActionListener(listenerForWDButton);
    }

}
