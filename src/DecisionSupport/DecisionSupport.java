package DecisionSupport;
import Data.*;

/**
 * Created by Pawel on 19-Jan-17.
 */

public class DecisionSupport {

    private CaseHolder data;

    public DecisionSupport(CaseHolder data1){
        data = data1;
    }

    public void makeDecision(float ryzyko, float gotowka){
        CaseHolder tmp = new CaseHolder();
        for(Case c: data.getCases()){
            float tmpR = c.getRyzyko();
            float tmpG = c.getGotowka();
            if((tmpR > (ryzyko-0.05f)) && (tmpR < (ryzyko+0.05f)) && (tmpG <= gotowka)){
                tmp.getCases().add(c);
            }
        }
        Case best = new Case();
        float zyskMax = 0.0f;
        for(Case c: tmp.getCases()){
            if(c.getZysk() > zyskMax){
                zyskMax = c.getZysk();
                best = c;
                System.out.println("znaleziony lepszy");
            }

        }
        best.print();
    }
}
