import java.util.*;

/*
 * handles meetings by processing the string that holds the information about the meeting and 
 * storing parallel ArrayLists for the days, start times, end times, and locations for all of
 * the meetings for a course
*/
public class Meetings {
	private ArrayList<String>   days;
	private ArrayList<Time>     starts;
	private ArrayList<Time>     ends;
	private String              location;
	
	//no-param constructor, just initialises all the ArrayLists
	public Meetings() {
		days = new ArrayList<String>();
		starts = new ArrayList<Time>();
		ends = new ArrayList<Time>();
	}
	
	//constructor for extracting informaiton from the datafile line in String form
	public Meetings(String s) {
		//grab the location from the raw line 
		location = s.substring(s.indexOf("<") + 1, s.indexOf(">"));

		//begin breaking out string represenation of meet times
		String allTimes = s.substring(s.indexOf("{") + 1, s.indexOf("}")); 

		//A list of string-coded meeting times, separated into individual entries
		ArrayList<String> mtgs = new ArrayList<String>();
		
		//break out String represenation of times into the mtgs ArrayList
		while (allTimes != "") {
			while (allTimes.contains("|")) {
				String mtg = allTimes.substring(0, allTimes.indexOf("|"));
				allTimes = allTimes.substring(allTimes.indexOf("|") + 1);

				mtgs.add(mtg);
			}

			mtgs.add(allTimes.substring(0, allTimes.length() - 1));
			allTimes = "";
		}

		ArrayList<String> days = new ArrayList<String>();
		ArrayList<Time> starts = new ArrayList<Time>();
		ArrayList<Time> ends = new ArrayList<Time>();
		
		//break each mtg entry into its parts to store in the class fields
		for (String mt : mtgs) {
			days.add(mt.substring(1, 2));
			try {
				starts.add(new Time(mt.substring(3, 8)));
				ends.add(new Time(mt.substring(9, 14)));
			} catch (TimeFormatException e) {
				System.out.println(e.getMessage());
				System.exit(69);
			}
		}

		//mts = new MeetTimes(days, starts, ends, location);

		this.days = days;
		this.starts = starts;
		this.ends = ends;
		this.location = location;
	}

	//constructor for being handed ArrayLists containing pre-broken items
	@SuppressWarnings("unchecked")
	public Meetings(ArrayList<String> days, ArrayList<Time> starts, ArrayList<Time> ends, String location) {
		this.days = (ArrayList<String>)days.clone();
		this.starts = (ArrayList<Time>)starts.clone();
		this.ends = (ArrayList<Time>)ends.clone();
		this.location = location;
	}

	//return an ArrayList containing the meeting days, start times, and end times in that order 
	public ArrayList<Object> getMeeting(int n) {
		ArrayList<Object> out = new ArrayList<Object>();
		out.add(days.get(n));
		out.add(starts.get(n));
		out.add(ends.get(n));

		return out;
	}
	
	/*
	public ArrayList<Object> getAllMeetings() {
		ArrayList<Object> out = new ArrayList<Object>();
		out.add(days);
		out.add(starts);
		out.add(ends);

		return out;
	} */

	//getter for the location of this class
	public String getLocation() {
		return location;
	}
}
