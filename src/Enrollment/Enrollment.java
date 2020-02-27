import java.io.*;
import java.util.*;

/*
 * Enrollment 
 * Holds an ArrayList of Classes and 
 */
public class Enrollment {
	//hold the classes being offered 
	ArrayList<Class> cl;

	public Enrollment(String classFile) {
		//Set up the Scanner to read from the data file 
		Scanner sc = new Scanner("WORDS");
		try {
			File inFile = new File(classFile);
			sc = new Scanner(inFile);
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
			System.exit(1);
		}
		
		//initialise the class list 
		cl = new ArrayList<Class>();
		
		//read the scanner to extract from the data file line by line 
		while (sc.hasNext()) {
			String line = sc.nextLine();
			
			if (line.charAt(0) == '!') { //we read a Class
				cl.add(new Class(line));
			} else if (line.charAt(0) == '@') { //we read a Lecture
				cl.get(cl.size() - 1).subs.addSxn(new Lecture(line));
			} else if (line.charAt(0) == '#') { //we read a Section
				cl.get(cl.size() - 1).subs.getLastSxn().subs.addSxn(new Section(line));
			} else { //error message
				System.err.println("A line being read from the CLASS database file doesn't start with a marker!");
			}
		}
	}
	
	//print the class out
	public void print() {
		for (Class c : cl) { //for every Class...
			System.out.println(c.getName());
			
			for (int i = 0; i < c.subs.size(); i++) { //for every Lecture...
				Lecture l = c.subs.getSxn(i);
				System.out.println("-" + l.getName());
				
				for (int j = 0; j < l.subs.size(); j++) { //for every Section...
					Section s = l.subs.getSxn(j);
					System.out.println("--" + s.getName());
				}
			}
		} 
	}
}
