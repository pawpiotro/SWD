import DecisionSupport.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Pawel on 19-Jan-17.
 */
public class GUIInit {
    private DecisionSupport decision;
    private SWD okno;

    public GUIInit(){
        okno = new SWD();
    }

    class swdListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            float risk = okno.getRyzyko() / 100.0f;
            int fund = okno.getFund();
            int a = decision.makeDecision(risk, fund, 0.01f);
            switch(a){
                case 0:
                    System.out.println("Znaleziono.\n");
                    break;
                case 1:
                    System.out.println("Niepoprawne dane. (ryzyko)\n");
                    break;
                case 2:
                    System.out.println("Znaleziono, po zwiekszeniu zakresu ryzyka\n");
                    break;
                default:
            }
        }
    }

    public void addData(DecisionSupport decision1){
        decision = decision1;
        okno.addWDButtonListener(new swdListener());
    }
}
