package application.Length;

public class Conversions {
//	public float calculate(float n, String unit) {
//		switch (unit) {
//		case "Kilometer":
//			return n * 1000;
//		case "Meter":
//			return n;
//		case "Centimeter":
//			return n * 100;
//		case "Millimeter":
//			return n * 10000;
//		default:
//			return 0;
//		}
//	}
//
//	public float calculate1(float n1, String unit) {
//		switch (unit) {
//		case "Kilometer":
//			return n1 / 1000;
//		case "Meter":
//			return n1;
//		case "Centimeter":
//			return n1 / 100;
//		case "Millimeter":
//			return n1 / 10000;
//		default:
//			return 0;
//		}
//	}

	public double calculate(double n, String unit1, String unit2) {
		if (unit1 == "Kilometer" && unit2 == "Kilometer") {
			return n;
		}
		if (unit1 == "Kilometer" && unit2 == "Meter") {
			return n * 1000;
		}
		if (unit1 == "Kilometer" && unit2 == "Centimeter") {
			return n * 100000;
		}
		if (unit1 == "Kilometer" && unit2 == "Millimeter") {
			return n * 1000000;
		}
		if (unit1 == "Meter" && unit2 == "Meter") {
			return n;
		}
		if (unit1 == "Meter" && unit2 == "Kilometer") {
			return n * 0.001;
		}
		if (unit1 == "Meter" && unit2 == "Centimeter") {
			return n * 100;
		}
		if (unit1 == "Meter" && unit2 == "Millimeter") {
			return n * 1000;
		}

		if (unit1 == "Centimeter" && unit2 == "Centimeter") {
			return n;
		}

		if (unit1 == "Centimeter" && unit2 == "Meter") {
			return n * 0.01;
		}
		if (unit1 == "Centimeter" && unit2 == "Kilometer") {
			return n * 0.00001;
		}
		if (unit1 == "Centimeter" && unit2 == "Millimeter") {
			return n * 10;
		}
		if (unit1 == "Millimeter" && unit2 == "Millimeter") {
			return n;
		}
		if (unit1 == "Millimeter" && unit2 == "Meter") {
			return n * 0.001;
		}
		if (unit1 == "Millimeter" && unit2 == "Centimeter") {
			return n * 0.1;
		}
		if (unit1 == "Millimeter" && unit2 == "Kilometer") {
			return n * 0.000001;
		}

		return 0;
	}

}
