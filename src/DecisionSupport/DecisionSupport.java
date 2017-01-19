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

    public int makeDecision(float ryzyko, float gotowka, float e, boolean omitZero){
        if(ryzyko > 1.0f || ryzyko < 0.0f || e > 1.0f )
            return 1;
        boolean found = false;
        CaseHolder tmp = new CaseHolder();
        for(Case c: data.getCases()){
            float tmpR = c.getRyzyko();
            float tmpG = c.getGotowka();
            if((tmpR > (ryzyko-e)) && (tmpR < (ryzyko+e)) && (tmpG <= gotowka)){
                if(!(omitZero && tmpR == 0.0f))
                    tmp.getCases().add(c);
            }
        }
        Case best = new Case();
        float zyskMax = 0.0f;
        for(Case c: tmp.getCases()){
            if(c.getZysk() > zyskMax){
                zyskMax = c.getZysk();
                best = c;
                //System.out.println("znaleziony lepszy");
                found = true;
            }

        }
        if(found) {
            best.print();
            return 0;
        }
        else{
            makeDecision(ryzyko, gotowka, e+0.01f, omitZero);
            return 2;
        }
    }
}
