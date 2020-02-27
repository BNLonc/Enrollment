import java.util.*;

public class Section {
    private LinkedList  waitlist;
    private HashSet     enrolled;
    private String      name;
    private int         capacity;
    private Meetings    mts;

    public Section(String s) {
        name = s.substring(1, s.indexOf(":"));
        
        if (name.equals("")) {
            name = "(only one disco)";
        }

        capacity = Integer.parseInt(s.substring(s.indexOf("[") + 1, s.indexOf("]")));

        mts = new Meetings(s);
    }

    public String getName() {return name;}
}
