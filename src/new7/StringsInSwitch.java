package new7;

/**
 * JDK 7 New: Samples for Strings in switch Statements
 * @author SimonC
 * @see https://docs.oracle.com/javase/8/docs/technotes/guides/language/strings-switch.html
 */
public class StringsInSwitch {

	public static void main(String[] args) {
			System.out.println("Monday: " + getTypeOfDayWithSwitchStatement("Monday"));
			System.out.println("Tuesday: " + getTypeOfDayWithSwitchStatement("Tuesday"));
			System.out.println("Wednesday: " + getTypeOfDayWithSwitchStatement("Wednesday"));
			System.out.println("Thursday: " + getTypeOfDayWithSwitchStatement("Thursday"));
			System.out.println("Friday: " + getTypeOfDayWithSwitchStatement("Friday"));
			System.out.println("Saturday: " + getTypeOfDayWithSwitchStatement("Saturday"));
			System.out.println("Sunday: " + getTypeOfDayWithSwitchStatement("Sunday"));
			System.out.println("Mon: " + getTypeOfDayWithSwitchStatement("Mon"));
	}

	public static String getTypeOfDayWithSwitchStatement(String dayOfWeekArg) {
			String typeOfDay;
			switch (dayOfWeekArg) {
					case "Monday":
							typeOfDay = "Start of work week";
							break;
					case "Tuesday":
					case "Wednesday":
					case "Thursday":
							typeOfDay = "Midweek";
							break;
					case "Friday":
							typeOfDay = "End of work week";
							break;
					case "Saturday":
					case "Sunday":
							typeOfDay = "Weekend";
							break;
					default:
							throw new IllegalArgumentException("Invalid day of the week: " + dayOfWeekArg);
			}
			return typeOfDay;
	}
}
