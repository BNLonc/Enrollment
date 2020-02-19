/*
 * handles the custom data type for holding a 24-hour time, throws the TimeFormatException if it encounters something weird
 */
class Time {
	private byte hours;
	private byte mins;

	public Time() {
		hours = 0;
		mins = 0;
	}

	//CONSTRUCTORS: work with either (byte, byte) or (String) which processes the String
	public Time(String s) throws TimeFormatException {
		this(Byte.parseByte(s.substring(0, s.indexOf(":"))), Byte.parseByte(s.substring(s.indexOf(":") + 1)));
	}
	
	public Time(byte hours, byte mins) throws TimeFormatException {
		if (hours >= 0 && hours < 24) {
			if (mins >= 0 && mins < 60) {
				this.hours = hours;
				this.mins = mins;
			} else {
				throw new TimeFormatException("Value for minutes passed: " + mins + " is not between 0 and 59");
			}
		} else {
			throw new TimeFormatException("Value for hours passed: " + hours + " is not between 0 and 23");
		}
	}

	//GETTERS for hours and mins 
	public byte getHours() {
		return hours;
	}

	public byte getMins() {
		return mins;
	}
	
	//SETTERS for hour and mins, check for bad input
	public void setHours(byte hours) throws TimeFormatException {
		if (mins >= 0 && mins < 60) {
			this.hours = hours;
		} else {
			throw new TimeFormatException("Value for hours passed: " + hours + " is not between 0 and 23");
		}
	}

	public void setMins(byte mins) throws TimeFormatException {
		if (mins >= 0 && mins < 60) {
			this.mins = mins;
		} else {
			throw new TimeFormatException("Value for minutes passed: " + mins + " is not between 0 and 59");
		}
	}

	//MUTATORS that add or subtract some number of hours and minutes from the stored Time
	public void add(byte h, byte m) throws TimeFormatException {
		if (h < 0) {
			throw new TimeFormatException("Time.add() was passed a negative hour");
		} else if (m < 0) {
			throw new TimeFormatException("Time.add() was passed a negative minute");
		}

		if (m + mins >= 60) {
			byte addedMins = (byte)(m + mins);
			hours += addedMins % 60;
			mins += addedMins - ((addedMins / 60) * 60);
		} else {
			mins += m;
		}

		if (h >= 24) {
			hours = (byte)((hours + h) - (((hours + h) / 24) * 24));
		} else {
			hours += h;
		}
	}

	public void subtract(byte h, byte m) throws TimeFormatException {
		if (h < 0) {
			throw new TimeFormatException("Time.subtract() was passed a negative hour");
		} else if (m < 0) {
			throw new TimeFormatException("Time.subtract() was passed a negative minute"); 
		}

		hours -= h;
		mins -= m;

		while (mins < 0) {
			mins += 60;
			hours--;
		}

		while (hours < 0) {
			hours += 24;
		}
	}

	//TOSTRING that allows easy, implicit conversion for printing and such
	@Override
	public String toString() {
		return hours + ":" + mins;
	}
}
