package com.cryptography.otp;

public class App {

	public static void main(String[] args) {
		
		//String plainText = "This is a secret message";
		String plainText = "Shannon defined the quantity of information produced by a source for example the quantity in a message by a formula similar to the equation that defines thermodynamic entropy in physics In its most basic terms Shannons informational entropy is the number of binary digits required to encode a message Today that sounds like a simple even obvious way to define how much information is in a message In 1948 at the very dawn of the information age this digitizing of information of any sort was a revolutionary step His paper may have been the first to use the word bit short for binary digit As well as defining information Shannon analyzed the ability to send information through a communications channel He found that a channel had a certain maximum transmission rate that could not be exceeded Today we call that the bandwidth of the channel Shannon demonstrated mathematically that even in a noisy channel with a low bandwidth essentially perfect error-free communication could be achieved by keeping the transmission rate within the channels bandwidth and by using error correcting schemes the transmission of additional bits that would enable the data to be extracted from the noise-ridden signal Today everything from modems to music CDs rely on error correction to function A major accomplishment of quantum-information scientists has been the development of techniques to correct errors introduced in quantum information and to determine just how much can be done with a noisy quantum communications channel or with entangled quantum bits qubits whose entanglement has been partially degraded by noise";
		
		OneTimePad oneTimePad = new OneTimePad();
		
		//generate as many random values [0,ALPHABET SIZE] as the number of letters in the plaintext
		RandomSequenceGenerator randomSequenceGenerator = new RandomSequenceGenerator();
		int[] key = randomSequenceGenerator.generate(plainText.length());
		
		String cipherText = oneTimePad.encrypt(plainText,key);
		
		//analyze the frequency distribution of the encrypted text
		//note: every letter has the same probability in the plaintext - NO INFORMATION LEAKING
		FrequencyAnalysis frequencyAnalysis = new FrequencyAnalysis();
		frequencyAnalysis.showFrequencies(cipherText);
		
		System.out.println(cipherText);
		System.out.println(oneTimePad.decrypt(cipherText, key));
		
	}
}
