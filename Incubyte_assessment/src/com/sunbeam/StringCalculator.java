package com.sunbeam;

import java.util.ArrayList;

class InvalidException extends Exception {
	public InvalidException(String message) {
		super(message);
	}
}

public class StringCalculator {

	public static int add(String numbers) throws InvalidException {
		if (numbers.length() == 0)
			return 0;
		ArrayList<String> list = new ArrayList<>();
		String str = "";
		for (int i = 0; i < numbers.length(); i++) {

			if (numbers.charAt(i) >= 48 && numbers.charAt(i) <= 57)
				str += numbers.charAt(i);

			else {
				if (str.length() > 0)
					list.add(str);
				str = "";
			}
		}
		if (numbers.length() > 1 && numbers.substring(numbers.length() - 1).equals("\n"))
			throw new InvalidException("Invalid Input");
		if (str.length() > 0)
			list.add(str);
		int sum = 0;
		for (int i = 0; i < list.size(); i++)
			sum += Integer.parseInt(list.get(i));
		return sum;

	}

	public static void main(String[] args) {
		try {
			// System.out.println(add("1,2"));
//		System.out.println(add("1,2 ,3"));
//		System.out.println(add("1,2 , 3,4 ,5"));
//		System.out.println(add("1"));
			System.out.println(add("1\n2,3\n"));
		} catch (InvalidException e) {
			System.out.println(e.getMessage());
		}

	}

}
