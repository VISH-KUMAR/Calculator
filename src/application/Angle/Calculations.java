package application.Angle;

public class Calculations {
	public double angleConversion(double n, String unit1,String unit2) {
		if(unit1 == "Radians" && unit2 == "Radians") {
			return n;
		}
		if(unit1 == "Radians" && unit2 == "Degrees") {
			return Math.toDegrees(n);
		}
		if(unit1 == "Degrees" && unit2 == "Radians") {
			return Math.toRadians(n);
		}
		if(unit1 == "Degrees" && unit2 == "Degrees") {
			return n;
		}
		return 0;
	}

}
