import java.util.*;

public class Lecture {
    private String              name;
    public  SubSxns<Section>    subs;
    private Meetings            mts;

    public Lecture(String s) {
        name = s.substring(1, s.indexOf(":"));
        
        if (name.equals("")) {
            name = "(only one lecture)";
        }

        subs = new SubSxns<Section>();

        mts = new Meetings(s);
    }

    public String getName() {return name;}
}
