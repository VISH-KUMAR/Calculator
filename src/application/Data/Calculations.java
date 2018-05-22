package application.Data;

public class Calculations {
	public double dataConversion(double data, String unit1, String unit2) {
		if (unit1 == "Kilobyte" && unit2 == "Kilobyte") {
			return data;
		}
		if (unit1 == "Kilobyte" && unit2 == "Megabyte") {
			return data*0.001;
		}
		if (unit1 == "Kilobyte" && unit2 == "Gigabyte") {
			return data*0.000001;
		}
		if (unit1 == "Kilobyte" && unit2 == "Terabyte") {
			return data*0.000000001;
		}
		if (unit1 == "Megabyte" && unit2 == "Megabyte") {
			return data;
		}
		if (unit1 == "Megabyte" && unit2 == "Kilobyte") {
			return data*1000;
		}
		if (unit1 == "Megabyte" && unit2 == "Gigabyte") {
			return data*0.001f;
		}
		if (unit1 == "Megabyte" && unit2 == "Terabyte") {
			return data*0.000001;
		}
		if (unit1 == "Gigabyte" && unit2 == "Gigabyte") {
			return data;
		}
		if (unit1 == "Gigabyte" && unit2 == "Terabyte") {
			return data*0.001;
		}
		if (unit1 == "Gigabyte" && unit2 == "Kilobyte") {
			return data*1000000;
		}
		if (unit1 == "Gigabyte" && unit2 == "Megabyte") {
			return data*1000;
		}
		if (unit1 == "Terabyte" && unit2 == "Terabyte") {
			return data;
		}
		if (unit1 == "Terabyte" && unit2 == "Megabyte") {
			return data*1000000;
		}
		if (unit1 == "Terabyte" && unit2 == "Kilobyte") {
			return data*1000000000;
		}
		if (unit1 == "Terabyte" && unit2 == "Gigabyte") {
			return data*1000;
		}
		return 0;

	}
}
