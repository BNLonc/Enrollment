import java.util.*;
import java.io.*;
public class DataWriter {
	public static void main(String args[]) throws IOException {
		Scanner sc = new Scanner(System.in);

		//Strings that take inputs
		String Classin;
		String Lectrin;
		String Sectnin;

		String cap;
		String loc;
		String day;
		String str;
		String end;

		//file to write to
		FileWriter of = new FileWriter("../../data/CLASS_DATA2.txt");

		while (true) { //loop for getting classes
			System.out.print("\nEnter the class name: "); 
			Classin = sc.nextLine();
			
			if (Classin.equals("/")) {
				break;
			}
			
			of.write("!" + Classin);
			of.write('\n');

			while (true) { //loop for getting lectures
				System.out.print("\nEnter the lecture name: ");
				Lectrin = sc.nextLine();

				if (Lectrin.equals("/")) { //break with a sentinel
					break;
				}

				System.out.print("Enter the lecture location: ");
				loc = sc.nextLine();

				if (loc.equals("/")) {
					break;
				}

				String allDates = ""; //build up a string of all meetings

				while (true) { //loop for getting dates/times

					System.out.print("Enter the lecture day: ");
					day = sc.nextLine();

					if (day.equals("/")) {
						break;
					}

					System.out.print("Enter the lecture start time: ");
					str = sc.nextLine();
					
					if (str.equals("/")) {
						break;
					}

					System.out.print("Enter the lecture end time: ");
					end = sc.nextLine();
					
					if (end.equals("/")) {
						break;
					}

					allDates += ("(" + day + "," + str + "," + end + ")" + "|");
				}

				allDates = allDates.substring(0, allDates.length() - 1);

				of.write("@" + Lectrin + ": <" + loc + "> {" + allDates + "}");
				of.write('\n');
				
				//HANDLE SECTIONS
				while (true) {
					System.out.print("Enter the section name: ");
					Sectnin = sc.nextLine();

					if (Sectnin.equals("/")) { //break with a sentinel
						break;
					}
					
					System.out.print("Enter the section capacity: ");
					cap = sc.nextLine();

					if (cap.equals("/")) {
						break;
					}


					System.out.print("Enter the section location: ");
					loc = sc.nextLine();

					if (loc.equals("/")) {
						break;
					}

					allDates = ""; //build up a string of all meetings

					while (true) { //loop for getting dates/times

						System.out.print("Enter the discussion day: ");
						day = sc.nextLine();

						if (day.equals("/")) {
							break;
						}

						System.out.print("Enter the discussion start time: ");
						str = sc.nextLine();
						
						if (str.equals("/")) {
							break;
						}

						System.out.print("Enter the discussion end time: ");
						end = sc.nextLine();
						
						if (end.equals("/")) {
							break;
						}

						allDates += ("(" + day + "," + str + "," + end + ")" + "|");
					}

					allDates = allDates.substring(0, allDates.length() - 1);

					of.write("#" + Sectnin + ": [" + cap + "]  <" + loc + "> {" + allDates + "}");
					of.write('\n');
					
					if (Sectnin.equals("")) { //stop if it's just one lecture
						break;
					}

				}

				if (Lectrin.equals("")) { //stop if it's just one lecture
					break;
				}
			}
			
			
		}

		of.close();		
	}
}
