package application.Area;

public class Calculations {
	public double areaConversion(double n, String unit1, String unit2) {

		// conversion from square millimeter to other units
		if (unit1 == "Square Millimeter" && unit2 == "Square Millimeter") {
			return n;
		}
		if (unit1 == "Square Millimeter" && unit2 == "Square Centimeter") {
			return n*0.01;
		}
		if (unit1 == "Square Millimeter" && unit2 == "Square Meter") {
			return n*0.000001;
		}
		if (unit1 == "Square Millimeter" && unit2 == "Square Kilometers") {
			return n*0.000000000001;
		}
		if (unit1 == "Square Millimeter" && unit2 == "Square Inches") {
			return n*0.00155;
		}
		if (unit1 == "Square Millimeter" && unit2 == "Square Miles") {
			return n*0.00000000000039;
		}
		if (unit1 == "Square Millimeter" && unit2 == "Acres") {
			return n*0.0000000002471;
		}
		if (unit1 == "Square Millimeter" && unit2 == "Square Feet") {
			return n*0.000011;
		}
		// conversion from square centimeter to other units
		if (unit1 == "Square Centimeter" && unit2 == "Square Centimeter") {
			return n;
		}	
		if (unit1 == "Square Centimeter" && unit2 == "Square Millimeter") {
			return n*100;
		}
		if (unit1 == "Square Centimeter" && unit2 == "Square Meter") {
			return n*0.0001;
		}
		if (unit1 == "Square Centimeter" && unit2 == "Square Kilometers") {
			return n*0.0000000001;
		}
		if (unit1 == "Square Centimeter" && unit2 == "Square Inches") {
			return n*0.155;
		}
		if (unit1 == "Square Centimeter" && unit2 == "Square Miles") {
			return n*0.00000000003861;
		}
		if (unit1 == "Square Centimeter" && unit2 == "Acres") {
			return n*0.00000002471054;
		}
		if (unit1 == "Square Centimeter" && unit2 == "Square Feet") {
			return n*0.001076;
		}
		// conversion from square meter to other units
		if (unit1 == "Square Meter" && unit2 == "Square Meter") {
			return n;
		}
		if (unit1 == "Square Meter" && unit2 == "Square Millimeter") {
			return n*1000000;
		}
		if (unit1 == "Square Meter" && unit2 == "Square Centimeter") {
			return n*10000;
		}
		if (unit1 == "Square Meter" && unit2 == "Square Kilometers") {
			return n*0.000001;
		}
		if (unit1 == "Square Meter" && unit2 == "Square Inches") {
			return n*1550.003;
		}
		if (unit1 == "Square Meter" && unit2 == "Square Miles") {
			return n*0.00000038610216;
		}
		if (unit1 == "Square Meter" && unit2 == "Acres") {
			return n*0.000247;
		}
		if (unit1 == "Square Meter" && unit2 == "Square Feet") {
			return n*10.76391;
		}
		// conversion from square kilometer to other units
		if (unit1 == "Square Kilometers" && unit2 == "Square Kilometers") {
			return n;
		}
		if (unit1 == "Square Kilometers" && unit2 == "Square Millimeter") {
			return n*1000000000000d;
		}
		if (unit1 == "Square Kilometers" && unit2 == "Square Centimeter") {
			return n*10000000000d;
		}
		if (unit1 == "Square Kilometers" && unit2 == "Square Meter") {
			return n*1000000d;
		}
		if (unit1 == "Square Kilometers" && unit2 == "Square Inches") {
			return n*1550003100;
		}
		if (unit1 == "Square Kilometers" && unit2 == "Square Miles") {
			return n*0.386102;
		}
		if (unit1 == "Square Kilometers" && unit2 == "Acres") {
			return n*247.1054;
		}
		if (unit1 == "Square Kilometers" && unit2 == "Square Feet") {
			return n*10763910;
		}
		// conversion from square inches to other units
		if (unit1 == "Square Inches" && unit2 == "Square Inches") {
			return n;
		}
		if (unit1 == "Square Inches" && unit2 == "Square Millimeter") {
			return n*645.16;
		}
		if (unit1 == "Square Inches" && unit2 == "Square Centimeter") {
			return n*6.4516;
		}
		if (unit1 == "Square Inches" && unit2 == "Square Meter") {
			return n*0.000645;
		}
		if (unit1 == "Square Inches" && unit2 == "Square Kilometers") {
			return n*0.000000000645;
		}
		if (unit1 == "Square Inches" && unit2 == "Square Miles") {
			return n*0.000000000249;
		}
		if (unit1 == "Square Inches" && unit2 == "Acres") {
			return n*0.0000001594;
		}
		if (unit1 == "Square Inches" && unit2 == "Square Feet") {
			return n*0.006944;
		}
		// conversion from square miles to other units
		if (unit1 == "Square Miles" && unit2 == "Square Miles") {
			return n;
		}
		if (unit1 == "Square Miles" && unit2 == "Square Millimeter") {
			return n*2589988110336d;
		}
		if (unit1 == "Square Miles" && unit2 == "Square Centimeter") {
			return n*25899881103d;
		}
		if (unit1 == "Square Miles" && unit2 == "Square Meter") {
			return n*2589988;
		}
		if (unit1 == "Square Miles" && unit2 == "Square Kilometers") {
			return n*2.589988;
		}
		if (unit1 == "Square Miles" && unit2 == "Square Inches") {
			return n*4014489600d;
		}
		if (unit1 == "Square Miles" && unit2 == "Acres") {
			return n*640;
		}
		if (unit1 == "Square Miles" && unit2 == "Square Feet") {
			return n*27878400;
		}
		// conversion from acres to other units
		if (unit1 == "Acres" && unit2 == "Acres") {
			return n;
		}
		if (unit1 == "Acres" && unit2 == "Square Millimeter") {
			return n*4046856422d;
		}
		if (unit1 == "Acres" && unit2 == "Square Centimeter") {
			return n*40468564;
		}
		if (unit1 == "Acres" && unit2 == "Square Meter") {
			return n*4046.856;
		}
		if (unit1 == "Acres" && unit2 == "Square Kilometers") {
			return n*0.004047;
		}
		if (unit1 == "Acres" && unit2 == "Square Inches") {
			return n*6272640;
		}
		if (unit1 == "Acres" && unit2 == "Square Miles") {
			return n*0.001563;
		}
		if (unit1 == "Acres" && unit2 == "Square Feet") {
			return n*43560;
		}
		// conversion from square feet to other units
		if (unit1 == "Square Feet" && unit2 == "Square Feet") {
			return n;
		}
		if (unit1 == "Square Feet" && unit2 == "Square Millimeter") {
			return n*92903.4;
		}
		if (unit1 == "Square Feet" && unit2 == "Square Centimeter") {
			return n*929.0304;
		}
		if (unit1 == "Square Feet" && unit2 == "Square Meter") {
			return n*0.092903;
		}
		if (unit1 == "Square Feet" && unit2 == "Square Kilometers") {
			return n*0.000000092903;
		}
		if (unit1 == "Square Feet" && unit2 == "Square Inches") {
			return n*144;
		}
		if (unit1 == "Square Feet" && unit2 == "Square Miles") {
			return n*0.00000003587006;
		}
		if (unit1 == "Square Feet" && unit2 == "Acres") {
			return n*0.000023;
		}
		return 0;

	}

}
