package DecisionSupport;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Dominik on 2017-01-19.
 */
public class RyzykoSlider  extends JPanel {
    public RyzykoSlider() {

        super(true);
        this.setLayout(new BorderLayout());
        JSlider slider = new JSlider(JSlider.HORIZONTAL, 0, 50, 25);

        slider.setMinorTickSpacing(2);
        slider.setMajorTickSpacing(10);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);

        // We'll just use the standard numeric labels for now...
        slider.setLabelTable(slider.createStandardLabels(10));

        add(slider, BorderLayout.CENTER);
    }

    public static void main(String s[]) {
        JFrame frame = new JFrame("Slider Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new RyzykoSlider());
        frame.pack();
        frame.setVisible(true);
    }
}
