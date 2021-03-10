package com.cryptography;

public class PrimalityTest {

	public boolean isPrime(int num) {
		
		//numbers smaller than 2 can not be primes
		if(num<=2) return false;
		
		//even numbers can not be primes
		if(num%2==0) return false;
		
		//we have already checked numbers < 3
		//finding primes up to N we just have to check numbers up to sqrt(N)
		//increment by 2 because we have already considered even numbers
		for(int i=3;i<Math.floor(Math.sqrt(num));i+=2) {
			if(num%i==0)
				return false;
		}
		
		//it means the number is prime
		return true;
	}
}
