import DecisionSupport.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Pawel on 19-Jan-17.
 */
public class GUIInit {
    private DecisionSupport decision;
    private SWD okno;

    public GUIInit(DecisionSupport decision1){
        okno = new SWD();
        decision = decision1;
        okno.addWDButtonListener(new swdListener());
    }

    class swdListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            float risk = okno.getRyzyko() / 100.0f;
            int fund = okno.getFund();
            int a = decision.makeDecision(risk, fund, 0.01f);
            switch(a){
                case 0:
                    System.out.println("Znaleziono.");
                    break;
                case 1:
                    System.out.println("Niepoprawne dane. (ryzyko)");
                    break;
                case 2:
                    System.out.println("Znaleziono, po zwiekszeniu ryzyka");
                    break;
                default:
            }
        }
    }
}
