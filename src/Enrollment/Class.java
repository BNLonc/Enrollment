import java.util.*;

public class Class {
    private String          name;
    public SubSxns<Lecture> subs;
    
    public Class (String s) {
        name = s.substring(1);

        subs = new SubSxns<Lecture>();
    }

    public String getName() {return name;}

}

