package application.Speed;

public class Calculations {
	public double speedConversion(double n, String unit1, String unit2) {
		if (unit1 == "Meter/sec" && unit2 == "Meter/sec") {
			return n;
		}
		if (unit1 == "Meter/sec" && unit2 == "Kilometer/hour") {
			return n*3.6;
		}
		if (unit1 == "Meter/sec" && unit2 == "Miles/hour") {
			return n*2.2371;
		}
		if (unit1 == "Kilometer/hour" && unit2 == "Kilometer/hour") {
			return n;
		}
		if (unit1 == "Kilometer/hour" && unit2 == "Meter/sec") {
			return n*0.277778;
		}
		if (unit1 == "Kilometer/hour" && unit2 == "Miles/hour") {
			return n*0.62142;
		}
		if (unit1 == "Miles/hour" && unit2 == "Miles/hour") {
			return n;
		}

		if (unit1 == "Miles/hour" && unit2 == "Meter/sec") {
			return n*0.447;
		}
		if (unit1 == "Miles/hour" && unit2 == "Kilometer/hour") {
			return n*1.6092;
		}
		return 0;
	}

}
