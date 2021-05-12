package com.cryptography.crackcaesarlanguage;

public class App {

	public static void main(String[] args) {
		
		//we used Caesar encryption with key=3
		//Original text: "If he had anything confidential to say he wrote it in cipher that is by so changing the order of the letters of the alphabet that not a word could be made out"
		String cipherText = "LICKHCKDGCDQAWKLQJCFRQILGHQWLDOCWRCVDACKHCZURWHCLWCLQCFLSKHUCWKDWCLVCEACVRCFKDQJLQJCWKHCRUGHUCRICWKHCOHWWHUVCRICWKHCDOSKDEHWCWKDWCQRWCDCZRUGCFRXOGCEHCPDGHCRXW";
		
		CrackCaesar crackCaesar = new CrackCaesar();
		crackCaesar.crack(cipherText);
	}
}
