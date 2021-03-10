package com.cryptography;

public class IntegerFactorization {

	public void factorize(int num) {

		//the same reasoning as we discussed with primality test
		int limit = (int) Math.floor(Math.sqrt(num));
		
		//let's try to find the factors
		//note: if the given number has small factors: we can find it quite fast (!!!)
		for(int i=2;i<limit;i++) {
			if(num%i==0) {
				System.out.println("Factors: ["+i+","+num/i+"]");
			}
		}
	}
}
