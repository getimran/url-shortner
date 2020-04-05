package com.shrt.url;

public class CommonUtility {

	
	public static String generateRandomStringOfSize(int n) {
		String alphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "abcdefghijklmnopqrstuvxyz";

		// create StringBuffer size of AlphaNumericString 
		StringBuilder sb = new StringBuilder(n);

		for (int i = 0; i < n; i++) {

			// generate a random number between 
			// 0 to AlphaNumericString variable length 
			int index = (int) (alphaNumericString.length() * Math.random());

			// add Character one by one in end of sb 
			sb.append(alphaNumericString.charAt(index));
		}

		return sb.toString();
	}

}
