package application.programmerCalculator;

import java.math.BigInteger;

public class Calculations {
//	public void conversion(String str) {
//		if(unit == Binary) {
//			
//		}
//	}
	public String BinaryToBinaryConversion(String binaryString) {
		return binaryString;
	}
	public int BinaryToDecimalConversion(String binaryString) {
		int decimal=Integer.parseInt(binaryString,2);
		return decimal;
	}

	

	public String  BinaryToOctalConversion(String bin) {
		int decimal=Integer.parseInt(bin,2);
		String octal = Integer.toOctalString(decimal);
		return octal;
	}

	public String  BinaryToHexConversion(String bin) {
		int decimal=Integer.parseInt(bin,2);
		String hex = Integer.toHexString(decimal);
		return hex;
	}

	public int DecimalToDecimalConversion(int decimalNo) {
		return decimalNo;
	}

	public String DecimalToBinaryConversion(int  decimalNo) {
		String bin = Integer.toBinaryString(decimalNo);
		return bin;
	}

	public String DecimalToOctalConversion(int deci) {
		String octal = Integer.toOctalString(deci);
		return octal;
	}

	public String DecimalToHexConversion(int decimalNo) {
		String hex = Integer.toHexString(decimalNo);
		return hex;
	}

	public String OctalToOctalConversion(String oct) {
		return oct;
	}

	public String OctalToBinaryConversion(int oct) {
		String bin = Integer.toBinaryString(oct);
				return bin;
	}

	public int OctalToDecimalConversion(String oct) {
		int decimal=Integer.parseInt(oct,8);
		return decimal;
	}

	public String HexToHexConversion(String hex) {
		return hex;
	}

	public String  HexToBinaryConversion(String hex) {
//		String bin = Integer.toBinaryString(Integer.parseInt(hex, 16));
//		return bin;                                                               works for small numbers
			return	new BigInteger(hex, 16).toString(2);
	}

	public int HexToDecimalConversion(String hex) {
		int decimal=Integer.parseInt(hex,16); 
		return decimal;
	}

	public String HexToOctalConversion(String hex) {
		return	new BigInteger(hex, 16).toString(8);
	}

}
