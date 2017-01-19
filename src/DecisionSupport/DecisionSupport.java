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

    public boolean makeDecision(float ryzyko, float gotowka, float e){
        boolean found = false;
        CaseHolder tmp = new CaseHolder();
        for(Case c: data.getCases()){
            float tmpR = c.getRyzyko();
            float tmpG = c.getGotowka();
            if((tmpR > (ryzyko-e)) && (tmpR < (ryzyko+e)) && (tmpG <= gotowka)){
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
                found = true;
            }

        }
        if(found) {
            best.print();
            return true;
        }
        else{
            makeDecision(ryzyko, gotowka, e+0.01f);
            return false;
        }
    }
}
