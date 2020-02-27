//Driver for the Enrollment simulation
public class Execute {
	public static void main(String[] args) {
		System.out.println("STARTING ENROLLMENT SIMULATION");
		Enrollment e = new Enrollment("../../data/CLASS_DATA.txt");
		e.print();
		System.out.println("END OF ENROLLMENT SIMULATION");
	}
}
