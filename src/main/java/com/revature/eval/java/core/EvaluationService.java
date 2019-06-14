package com.revature.eval.java.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class EvaluationService {

	/**
	 * 1. Convert a phrase to its acronym. Techies love their TLA (Three Letter
	 * Acronyms)! Help generate some jargon by writing a program that converts a
	 * long name like Portable Network Graphics to its acronym (PNG).
	 * 
	 * @param phrase
	 * @return
	 */
	public String acronym(String phrase) {
		String sample;
		String acro = "" + phrase.charAt(0);
		sample = phrase;
		for (int i = 0; i < sample.length(); i++) {
			if (sample.charAt(i) == ' ' | sample.charAt(i) == ',' | sample.charAt(i) == '-') {
				String check = "" + sample.charAt(i + 1);

				if (!check.equals(" ")) {
					acro += sample.toUpperCase().charAt(i + 1) + "";
				}
			}
		}
		return acro;
	}

	/**
	 * 2. Given a word, compute the scrabble score for that word.
	 * 
	 * --Letter Values-- Letter Value A, E, I, O, U, L, N, R, S, T = 1; D, G = 2; B,
	 * C, M, P = 3; F, H, V, W, Y = 4; K = 5; J, X = 8; Q, Z = 10; Examples
	 * "cabbage" should be scored as worth 14 points:
	 * 
	 * 3 points for C, 1 point for A, twice 3 points for B, twice 2 points for G, 1
	 * point for E And to total:
	 * 
	 * 3 + 2*1 + 2*3 + 2 + 1 = 3 + 2 + 6 + 3 = 5 + 9 = 14
	 * 
	 * @param string
	 * @return
	 */
	public int getScrabbleScore(String string) {
		int score = 0;
		int total = 0;

		for (int i = 0; i < string.length(); i++) {
			char character = string.toUpperCase().charAt(i);
			switch (character) {
			case 'A':
				total += 1;
				break;
			case 'E':
				total += 1;
				break;
			case 'I':
				total += 1;
				break;
			case 'O':
				total += 1;
				break;
			case 'U':
				total += 1;
				break;
			case 'L':
				total += 1;
				break;
			case 'N':
				total += 1;
				break;
			case 'R':
				total += 1;
				break;
			case 'S':
				total += 1;
				break;
			case 'T':
				total += 1;
				break;
			case 'D':
				total += 2;
				break;
			case 'G':
				total += 2;
				break;
			case 'M':
				total += 3;
				break;
			case 'P':
				total += 3;
				break;
			case 'C':
				total += 3;
				break;
			case 'B':
				total += 3;
				break;
			case 'F':
				total += 4;
				break;
			case 'H':
				total += 4;
				break;
			case 'V':
				total += 4;
				break;
			case 'W':
				total += 4;
				break;
			case 'Y':
				total += 4;
				break;
			case 'K':
				total += 5;
				break;
			case 'X':
				total += 8;
				break;
			case 'Q':
				total += 10;
				break;
			case 'Z':
				total += 10;
				break;
			}
		}

		return total;
	}

	/**
	 * 3. Clean up user-entered phone numbers so that they can be sent SMS messages.
	 * 
	 * The North American Numbering Plan (NANP) is a telephone numbering system used
	 * by many countries in North America like the United States, Canada or Bermuda.
	 * All NANP-countries share the same international country code: 1.
	 * 
	 * NANP numbers are ten-digit numbers consisting of a three-digit Numbering Plan
	 * Area code, commonly known as area code, followed by a seven-digit local
	 * number. The first three digits of the local number represent the exchange
	 * code, followed by the unique four-digit number which is the subscriber
	 * number.
	 * 
	 * The format is usually represented as
	 * 
	 * 1 (NXX)-NXX-XXXX where N is any digit from 2 through 9 and X is any digit
	 * from 0 through 9.
	 * 
	 * Your task is to clean up differently formatted telephone numbers by removing
	 * punctuation and the country code (1) if present.
	 * 
	 * For example, the inputs
	 * 
	 * +1 (613)-995-0253 613-995-0253 1 613 995 0253 613.995.0253 should all produce
	 * the output
	 * 
	 * 6139950253
	 * 
	 * Note: As this exercise only deals with telephone numbers used in
	 * NANP-countries, only 1 is considered a valid country code.
	 */
	public String cleanPhoneNumber(String string) {
		String number = "";
		for (int i = 0; i < string.length(); i++) {
			if (string.charAt(0) == '+' && string.charAt(1) == '1') {
				i += 2;
			}
			if (string.charAt(0) == '1') {
				i++;
			}
			if (string.charAt(i) != ' ' && string.charAt(i) != '-' && string.charAt(i) != '_' && string.charAt(i) != '.'
					&& string.charAt(i) != '(' && string.charAt(i) != ')') {
				number = number + string.charAt(i);
			}
		}
		if (number.length() > 10 || number.length() < 10) {
			throw new IllegalArgumentException();
		}

		return number;

	}

	/**
	 * 4. Given a phrase, count the occurrences of each word in that phrase.
	 * 
	 * For example for the input "olly olly in come free" olly: 2 in: 1 come: 1
	 * free: 1
	 * 
	 * @param string
	 * @return
	 */
	public Map<String, Integer> wordCount(String string) {
		Map<String, Integer> map = new HashMap<>();
		string=string.replaceAll("[\r\n]+","");
		String[] s=string.replace(","," " ).split(" ");
		
//		Set<String> setList = new HashSet<>();

//		for(String x: s) {
//			setList.add(x);
//		}
//		int i=1;
		
		for(String b: s) {
			
			if(map.containsKey(b)) {
				map.put(b, map.get(b) + 1);
			} else {
				map.put(b, 1);
			}
		}
		
		
		return map;
	}

	/**
	 * 5. Implement a binary search algorithm.
	 * 
	 * Searching a sorted collection is a common task. A dictionary is a sorted list
	 * of word definitions. Given a word, one can find its definition. A telephone
	 * book is a sorted list of people's names, addresses, and telephone numbers.
	 * Knowing someone's name allows one to quickly find their telephone number and
	 * address.
	 * 
	 * If the list to be searched contains more than a few items (a dozen, say) a
	 * binary search will require far fewer comparisons than a linear search, but it
	 * imposes the requirement that the list be sorted.
	 * 
	 * In computer science, a binary search or half-interval search algorithm finds
	 * the position of a specified input value (the search "key") within an array
	 * sorted by key value.
	 * 
	 * In each step, the algorithm compares the search key value with the key value
	 * of the middle element of the array.
	 * 
	 * If the keys match, then a matching element has been found and its index, or
	 * position, is returned.
	 * 
	 * Otherwise, if the search key is less than the middle element's key, then the
	 * algorithm repeats its action on the sub-array to the left of the middle
	 * element or, if the search key is greater, on the sub-array to the right.
	 * 
	 * If the remaining array to be searched is empty, then the key cannot be found
	 * in the array and a special "not found" indication is returned.
	 * 
	 * A binary search halves the number of items to check with each iteration, so
	 * locating an item (or determining its absence) takes logarithmic time. A
	 * binary search is a dichotomic divide and conquer search algorithm..
	 * 
	 */
	static class BinarySearch<T> {
		private List<T> sortedList;

		public int indexOf(T t) {
			
			int lower=0;
			int higher=sortedList.size()-1;
			int placeHolder=sortedList.size()-1;
			
			while(higher>lower)
			{
				placeHolder=(higher+lower)/2;
				if(t.equals(sortedList.get(placeHolder))) {
					return placeHolder;
				}
				else if(placeHolder>sortedList.indexOf(t)) {
					higher=placeHolder;
					placeHolder=(placeHolder+lower)/2;
				}else if(placeHolder<sortedList.indexOf(t)){
					lower=placeHolder;
					placeHolder=(placeHolder+higher)/2;
				}
				if(t.equals(sortedList.get(placeHolder))) {
					return placeHolder;
				}
				if (lower==placeHolder) {
					return higher;
				}
				if(higher==placeHolder) {
					return lower;
				}
				
			}
			
			return placeHolder;
		}

		public BinarySearch(List<T> sortedList) {
			super();
			this.sortedList = sortedList;
		}

		public List<T> getSortedList() {
			return sortedList;
		}

		public void setSortedList(List<T> sortedList) {
			this.sortedList = sortedList;
		}

	}

	/**
	 * 6. An Armstrong number is a number that is the sum of its own digits each
	 * raised to the power of the number of digits.
	 * 
	 * For example:
	 * 
	 * 9 is an Armstrong number, because 9 = 9^1 = 9 10 is not an Armstrong number,
	 * because 10 != 1^2 + 0^2 = 2 153 is an Armstrong number, because: 153 = 1^3 +
	 * 5^3 + 3^3 = 1 + 125 + 27 = 153 154 is not an Armstrong number, because: 154
	 * != 1^3 + 5^3 + 4^3 = 1 + 125 + 64 = 190 Write some code to determine whether
	 * a number is an Armstrong number.
	 * 
	 * @param input
	 * @return
	 */
	public boolean isArmstrongNumber(int input) {
		int num = input;
		LinkedList<Integer> list = new LinkedList<>();
		while (num > 0) {
			list.push(num % 10);
			num = num / 10;
		}
		int power = list.size();
		int digit;
		double total = 0;
		for (int i = 0; i < list.size(); i++) {
			digit = list.get(i);
			total += Math.pow(digit, power);
		}
		if (total == input) {
			return true;
		}

		return false;
	}

	/**
	 * 7. Compute the prime factors of a given natural number.
	 * 
	 * A prime number is only evenly divisible by itself and 1.
	 * 
	 * Note that 1 is not a prime number.
	 * 
	 * @param l
	 * @return
	 */
	public List<Long> calculatePrimeFactorsOf(long l) {
		List<Long> list = new ArrayList<>();

		while (l % 2 == 0) {

			list.add((long) 2);
			l = l / 2;
		}
		for (int i = 3; i <= Math.sqrt(l); i += 2) {
			while (l % i == 0) {
				list.add((long) i);
				l /= i;
			}
		}
		if (l > 2) {
			list.add(l);
		}
		return list;
	}

	/**
	 * 8-9. Create an implementation of the atbash cipher, an ancient encryption
	 * system created in the Middle East.
	 * 
	 * The Atbash cipher is a simple substitution cipher that relies on transposing
	 * all the letters in the alphabet such that the resulting alphabet is
	 * backwards. The first letter is replaced with the last letter, the second with
	 * the second-last, and so on.
	 * 
	 * An Atbash cipher for the Latin alphabet would be as follows:
	 * 
	 * Plain: abcdefghijklmnopqrstuvwxyz Cipher: zyxwvutsrqponmlkjihgfedcba It is a
	 * very weak cipher because it only has one possible key, and it is a simple
	 * monoalphabetic substitution cipher. However, this may not have been an issue
	 * in the cipher's time.
	 * 
	 * Ciphertext is written out in groups of fixed length, the traditional group
	 * size being 5 letters, and punctuation is excluded. This is to make it harder
	 * to guess things based on word boundaries.
	 * 
	 * Examples Encoding test gives gvhg Decoding gvhg gives test Decoding gsvjf
	 * rxpyi ldmul cqfnk hlevi gsvoz abwlt gives thequickbrownfoxjumpsoverthelazydog
	 *
	 */
	static class AtbashCipher {

		/**
		 * Question 8
		 * 
		 * @param string
		 * @return
		 */
		public static String encode(String string) {
			char[] list= string.replace(" ", "").toUpperCase().toCharArray();
			Map<Character, Character> map = new HashMap<>();
			map.put('A', 'Z');
			map.put('B', 'Y');
			map.put('C', 'X');
			map.put('D', 'W');
			map.put('E', 'V');
			map.put('F', 'U');
			map.put('G', 'T');
			map.put('H', 'S');
			map.put('I', 'R');
			map.put('J', 'Q');
			map.put('K', 'P');
			map.put('L', 'O');
			map.put('M', 'N');
			map.put('N', 'M');
			map.put('O', 'L');
			map.put('P', 'K');
			map.put('Q', 'J');
			map.put('R','I');
			map.put('S', 'H');
			map.put('T', 'G');
			map.put('U', 'F');
			map.put('V', 'E');
			map.put('W', 'D');
			map.put('X', 'C');
			map.put('Y', 'B');
			map.put('Z', 'A');
			String code="";
			int counter = 0;
			for(char x: list) {

				if(counter==5 ) {
					code= code+" ";
					counter=0;
				}
				
				if (map.get(x) != null) {
					code += map.get(x);
					counter++;
				}
				
				if (Character.isDigit(x)) {
					code += x;
					counter++;
				}
				
				
			}
			if (code.charAt(code.length()-1) == ' ') {
				return code.toLowerCase().substring(0, code.length()-1);
			}
			return code.toLowerCase();
		}

		/**
		 * Question 9
		 * 
		 * @param string
		 * @return
		 */
		public static String decode(String string) {
			char[] list= string.replace(" ", "").toUpperCase().toCharArray();
			Map<Character, Character> map = new HashMap<>();
			map.put('A', 'Z');
			map.put('B', 'Y');
			map.put('C', 'X');
			map.put('D', 'W');
			map.put('E', 'V');
			map.put('F', 'U');
			map.put('G', 'T');
			map.put('H', 'S');
			map.put('I', 'R');
			map.put('J', 'Q');
			map.put('K', 'P');
			map.put('L', 'O');
			map.put('M', 'N');
			map.put('N', 'M');
			map.put('O', 'L');
			map.put('P', 'K');
			map.put('Q', 'J');
			map.put('R','I');
			map.put('S', 'H');
			map.put('T', 'G');
			map.put('U', 'F');
			map.put('V', 'E');
			map.put('W', 'D');
			map.put('X', 'C');
			map.put('Y', 'B');
			map.put('Z', 'A');
			String code="";
			for(char x: list) {
				if (map.get(x) != null) {
					code += map.get(x);
				}
				if (Character.isDigit(x)) {
					code += x;
			}
			}
				if (code.charAt(code.length()-1) == ' ') {
					return code.toLowerCase().substring(0, code.length()-1);
				}
				return code.toLowerCase();
		
	}}

	/**
	 * 10. Parse and evaluate simple math word problems returning the answer as an
	 * integer.
	 * 
	 * Add two numbers together.
	 * 
	 * What is 5 plus 13?
	 * 
	 * 18
	 * 
	 * Now, perform the other three operations.
	 * 
	 * What is 7 minus 5?
	 * 
	 * 2
	 * 
	 * What is 6 multiplied by 4?
	 * 
	 * 24
	 * 
	 * What is 25 divided by 5?
	 * 
	 * 5
	 * 
	 * @param string
	 * @return
	 */
	public int solveWordProblem(String string) {
		String bs = string.replace('?', ' ');
		 
		String[] prompt = bs.split(" ");
		int numberOne = 0;
		int numberTwo = 0;
		String sign = null;
		int result;

		try {
			numberOne = Integer.parseInt(prompt[2]);
			sign = prompt[3];
			if (prompt[4].equalsIgnoreCase("by")) {
				numberTwo = Integer.parseInt(prompt[5]);

			} else {

				numberTwo = Integer.parseInt(prompt[4]);
			}

		} catch (Exception e) {

		}
		switch (sign) {
		case "plus":
			return result = numberOne + numberTwo;

		case "minus":
			return result = numberOne - numberTwo;

		case "divided":
			return result = numberOne / numberTwo;

		case "multiplied":
			return result = numberOne * numberTwo;
		}

		return 0;
	}

}
