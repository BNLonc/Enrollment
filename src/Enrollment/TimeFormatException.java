/*
 * A simple custom exception to be thrown when the user gives me values for Time 
 * that don't make any sense
 */
public class TimeFormatException extends Exception {
	private String msg;

	public TimeFormatException(String msg) {
		this.msg = msg;
	}

	@Override
	public String getMessage() {
		return msg;
	}
}
