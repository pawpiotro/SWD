package Data;

import java.util.ArrayList;

/**
 * Created by Pawel on 19-Jan-17.
 */
public class CaseHolder {
    private ArrayList<Case> cases = new ArrayList<>();

    public ArrayList<Case> getCases() {
        return cases;
    }

    public void printAll(){
        for(Case c: cases){
            c.print();
        }
    }
}
