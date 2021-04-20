import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class correlation {
    public static void main(String[] args) {

        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Enter Cipher string: ");

        String cipherString = myObj.nextLine();  // Read user input
        System.out.println("Cipher string: " + cipherString);  // Output user input

        String alphabetString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String newCipherString = "";
        HashSet<Character> cipherSet = new HashSet<>();
        for(int i = 0; i < cipherString.length(); i++){
            if(!cipherSet.contains(cipherString.charAt(i))) {
                cipherSet.add(cipherString.charAt(i));
                newCipherString += cipherString.charAt(i);
            }
        }
        //System.out.println(cipherSet);
        System.out.println("Single character cipher string: " + newCipherString);
        System.out.println("");
        //hashmap to store the character frequencies.
        HashMap<Character, Float> charFrequencyMap = new HashMap<>();
        charFrequencyMap.put('A', 0.080f);
        charFrequencyMap.put('B', 0.015f);
        charFrequencyMap.put('C', 0.030f);
        charFrequencyMap.put('D', 0.040f);
        charFrequencyMap.put('E', 0.130f);
        charFrequencyMap.put('F', 0.020f);
        charFrequencyMap.put('G', 0.015f);
        charFrequencyMap.put('H', 0.060f);
        charFrequencyMap.put('I', 0.065f);
        charFrequencyMap.put('J', 0.005f);
        charFrequencyMap.put('K', 0.005f);
        charFrequencyMap.put('L', 0.035f);
        charFrequencyMap.put('M', 0.030f);
        charFrequencyMap.put('N', 0.070f);
        charFrequencyMap.put('O', 0.080f);
        charFrequencyMap.put('P', 0.020f);
        charFrequencyMap.put('Q', 0.002f);
        charFrequencyMap.put('R', 0.065f);
        charFrequencyMap.put('S', 0.060f);
        charFrequencyMap.put('T', 0.090f);
        charFrequencyMap.put('U', 0.030f);
        charFrequencyMap.put('V', 0.010f);
        charFrequencyMap.put('W', 0.015f);
        charFrequencyMap.put('X', 0.005f);
        charFrequencyMap.put('Y', 0.020f);
        charFrequencyMap.put('Z', 0.002f);

        //hashmap to store the cipher character frequencies.
        HashMap<Character, Float> cipherTextFrequencyMap = new HashMap<>();
        cipherTextFrequencyMap.put('A', 0.000f);
        cipherTextFrequencyMap.put('B', 0.179f);
        cipherTextFrequencyMap.put('C', 0.036f);
        cipherTextFrequencyMap.put('D', 0.000f);
        cipherTextFrequencyMap.put('E', 0.107f);
        cipherTextFrequencyMap.put('F', 0.036f);
        cipherTextFrequencyMap.put('G', 0.000f);
        cipherTextFrequencyMap.put('H', 0.000f);
        cipherTextFrequencyMap.put('I', 0.000f);
        cipherTextFrequencyMap.put('J', 0.036f);
        cipherTextFrequencyMap.put('K', 0.143f);
        cipherTextFrequencyMap.put('L', 0.071f);
        cipherTextFrequencyMap.put('M', 0.000f);
        cipherTextFrequencyMap.put('N', 0.000f);
        cipherTextFrequencyMap.put('O', 0.036f);
        cipherTextFrequencyMap.put('P', 0.071f);
        cipherTextFrequencyMap.put('Q', 0.071f);
        cipherTextFrequencyMap.put('R', 0.071f);
        cipherTextFrequencyMap.put('S', 0.036f);
        cipherTextFrequencyMap.put('T', 0.036f);
        cipherTextFrequencyMap.put('U', 0.000f);
        cipherTextFrequencyMap.put('V', 0.000f);
        cipherTextFrequencyMap.put('W', 0.000f);
        cipherTextFrequencyMap.put('X', 0.036f);
        cipherTextFrequencyMap.put('Y', 0.000f);
        cipherTextFrequencyMap.put('Z', 0.036f);

        //hashmap to store character numbers
        HashMap<Character, Integer> alphabet = new HashMap<>();
        alphabet.put('A', 0);
        alphabet.put('B', 1);
        alphabet.put('C', 2);
        alphabet.put('D', 3);
        alphabet.put('E', 4);
        alphabet.put('F', 5);
        alphabet.put('G', 6);
        alphabet.put('H', 7);
        alphabet.put('I', 8);
        alphabet.put('J', 9);
        alphabet.put('K', 10);
        alphabet.put('L', 11);
        alphabet.put('M', 12);
        alphabet.put('N', 13);
        alphabet.put('O', 14);
        alphabet.put('P', 15);
        alphabet.put('Q', 16);
        alphabet.put('R', 17);
        alphabet.put('S', 18);
        alphabet.put('T', 19);
        alphabet.put('U', 20);
        alphabet.put('V', 21);
        alphabet.put('W', 22);
        alphabet.put('X', 23);
        alphabet.put('Y', 24);
        alphabet.put('Z', 25);

        //hashmap to correlate integer to its character
        HashMap<Integer, Character> backwards = new HashMap<>();
        backwards.put(0, 'A');
        backwards.put(1, 'B');
        backwards.put(2, 'C');
        backwards.put(3, 'D');
        backwards.put(4, 'E');
        backwards.put(5, 'F');
        backwards.put(6, 'G');
        backwards.put(7, 'H');
        backwards.put(8, 'I');
        backwards.put(9, 'J');
        backwards.put(10, 'K');
        backwards.put(11, 'L');
        backwards.put(12, 'M');
        backwards.put(13, 'N');
        backwards.put(14, 'O');
        backwards.put(15, 'P');
        backwards.put(16, 'Q');
        backwards.put(17, 'R');
        backwards.put(18, 'S');
        backwards.put(19, 'T');
        backwards.put(20, 'U');
        backwards.put(21, 'V');
        backwards.put(22, 'W');
        backwards.put(23, 'X');
        backwards.put(24, 'Y');
        backwards.put(25, 'Z');

        //mult array stores values for multiplication of cipher frequency and p
        float [] mult = new float[alphabetString.length()]; //length 26. 0-25

        float correlationTotal = 0.0f;
        Integer p = 0;
        char pChar;
        float multP = 0f;
        float multFreq = 0f;
        float calc = 0f;
        float multTotal = 0f;
        //traverse through alphabet using for loop
        for (int i = 0; i < alphabetString.length(); i++) {
            System.out.println("iteration " + i);
            for (int j = 0; j < newCipherString.length(); j++) {
                //lets figure out P value. if value < 0 add 26.
                p = alphabet.get((newCipherString.charAt(j))) - i;
                if (p < 0) {
                    p += 26;
                    //System.out.println(i);
                    System.out.println("p = " + "" +p);
                } else {
                    //System.out.println(i);
                    System.out.println("p = " + "" +p);
                }
                pChar = backwards.get(p);
                System.out.println(pChar);
                multP = charFrequencyMap.get(pChar);
                System.out.println("Char frequency: " + multP);
                multFreq = cipherTextFrequencyMap.get((newCipherString.charAt(j)));
                System.out.println("Cipher frequency: " + multFreq);
                multTotal = (multP *multFreq);
                System.out.println("char*cipher: " + multTotal);
                calc += (multTotal);
                System.out.println("Correlation Total: " + calc);
            }
            mult[i] = calc;
            System.out.println("total correlation for i = " + i + ": " + mult[i]);
            System.out.println("  ");
            calc = 0f;
        }
        System.out.println("FINAL RESULTS");
        for(int i = 0; i < mult.length;i++){
            System.out.println(i + " " + backwards.get(i) + " " + mult[i]);
        }
    }
}

