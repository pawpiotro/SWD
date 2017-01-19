import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

/**
 * Created by Dominik on 2017-01-19.
 */
public class SWD {
    private JSlider RyzykoInput;
    private JButton WDButton;
    private JLabel RyzykoLabel;
    private JPanel panel;
    private JLabel LabelRyzyko;
    private JLabel LabelSrodki;
    private JSpinner FundInput;
    private JTextArea Komunikat;
    private JCheckBox zeroCheck;

    public SWD() {

        JFrame frame = new JFrame("SWD");
        frame.setContentPane(this.panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        setCustomOutput(Komunikat);

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

    public int getRyzyko(){
        return RyzykoInput.getValue();
    }

    public int getFund(){
        return (Integer) FundInput.getValue();
    }
    public boolean omitZero(){
        return zeroCheck.isSelected();
    }
    private void setCustomOutput(JTextArea area) {
        PrintStream print_stream = new PrintStream(new CustomOutputStream(area));
        //podmiana standardowego strumienia
        System.setOut(print_stream);
        System.setErr(print_stream);
    }

}
