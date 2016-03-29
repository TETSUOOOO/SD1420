package com.prime;

import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public int idx = 0;

	private boolean isPrime(int num) {
		if (num == 2)
			return true;
		for (int i = 2; i < num-1; i++) {
			if (num % i == 0)
				return false;
	}
		return true;
	}
	private int getPrime(int nth) {
		int num = 2;
		for (int cnt_prime = -1; cnt_prime < nth;) {
			if (isPrime(num))
				cnt_prime++;
			num++;
			if (cnt_prime == nth)
				num--;
		}
		return num;
	}
	private void run() {
		System.out.printf("Enter an index ");
		idx = getIndex();
		
		// testing index
		
		System.out.printf("prime: %d", getPrime(idx));
	}

	private int getIndex() {
		String input = "";
		String prompt = "> ";

		Console c = System.console();
		if (c != null) {
			input = c.readLine(prompt);
		} else {
			System.out.println(prompt);
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
			try {
				input = bufferedReader.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		idx = Integer.parseInt(input);
		return idx;
	}

	public static void main(String[] args) {
		Main m = new Main();
		m.run();

	}

}