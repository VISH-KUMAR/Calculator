package application.Temperature;

public class Calculations {

	public double temperatureConversion(double n, String unit1, String unit2) {
		if (unit1 == "°C" && unit2 == "°C") {
			return n;
		}
		if (unit1 == "°C" && unit2 == "°F") {
			return n*1.8 + 32;
		}
		if (unit1 == "°C" && unit2 == "Kelvin") {
			return n + 273.15;
		}
		if (unit1 == "°F" && unit2 == "°F") {
			return n;
		}
		if (unit1 == "°F" && unit2 == "°C") {
			return (n-32)*5/9;
		}

		if (unit1 == "°F" && unit2 == "Kelvin") {
			return (n + 459.67)*5/9;
		}
		if (unit1 == "Kelvin" && unit2 == "Kelvin") {
			return n;
		}
		if (unit1 == "Kelvin" && unit2 == "°C") {
			return n-273.15;
		}
		if (unit1 == "Kelvin" && unit2 == "°F") {
			return (n-273.15)*9/5 +32;
		}

		return 0;
	}

}
