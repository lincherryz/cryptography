import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Arrays;


public class correlation {
    public static void main(String[] args) {

        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Enter Cipher string: ");

        String cipherString = myObj.nextLine();  // Read user input
        System.out.println("Cipher string: " + cipherString);  // Output user input

        //hashmap to store the 1-gram (plaintext) character frequencies.
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
        for (char i = 'A'; i <= 'Z'; i++)
            cipherTextFrequencyMap.put(i, 0.000f);
        //System.out.println(Arrays.asList(cipherTextFrequencyMap));

        //hashmap to store character numbers
        HashMap<Character, Integer> alphabet = new HashMap<>();
        int k = 0;
        for (char i = 'A'; i <= 'Z'; i++) {
            alphabet.put(i, k);
            k++;
        }
        //System.out.println(Arrays.asList(alphabet));

        //hashmap to correlate integer to its character
        HashMap<Integer, Character> backwards = new HashMap<>();
        int l = 0;
        for (char i = 'A'; i <= 'Z'; i++) {
            backwards.put(l, i);
            l++;
        }
        //System.out.println(Arrays.asList(backwards));

        //sort the cipher string
        char tempArray[] = cipherString.toCharArray(); // convert input string to char array
        Arrays.sort(tempArray); // sort tempArray
        String sortedCipherString = new String(tempArray);
        System.out.println("Sorted single character cipher string: " + sortedCipherString);
        System.out.println("");

        //count number of times character appears in cipher string
        int MAX_CHAR = 256;
        float count[] = new float[MAX_CHAR]; // Create an array of size 256 i.e. ASCII_SIZE
        int cipherLength = sortedCipherString.length();
        for (int i = 0; i < cipherLength; i++)  // Initialize count array index
            count[sortedCipherString.charAt(i)]++;
        char ch[] = new char[sortedCipherString.length()];// Create an array of given String size
        for (int i = 0; i < cipherLength; i++) {
            ch[i] = sortedCipherString.charAt(i);
            int find = 0;
            for (int j = 0; j <= i; j++) {
                if (sortedCipherString.charAt(i) == ch[j]) // If any matches found
                    find++;
            }
            if (find == 1) {
                //update cipher hashmap with correct cipher text frequencies for given string
                cipherTextFrequencyMap.put(sortedCipherString.charAt(i), (count[sortedCipherString.charAt(i)] / cipherLength));
                //prints letter followed by number of occurrence
                //System.out.println("Number of Occurrence of " + sortedCipherString.charAt(i) + " is:" + count[sortedCipherString.charAt(i)]);
            }
        }
        //System.out.println("New HashMap: " + cipherTextFrequencyMap.toString());

        //creates a single character cipher string
        String alphabetString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String newCipherString = "";
        HashSet<Character> cipherSet = new HashSet<>();
        for(int i = 0; i < cipherString.length(); i++){
            if(!cipherSet.contains(cipherString.charAt(i))) {
                cipherSet.add(cipherString.charAt(i));
                newCipherString += cipherString.charAt(i);
            }
        }
        System.out.println("Single character cipher string: " + newCipherString);

        //sort the new cipher string
        char newTempArray[] = newCipherString.toCharArray(); // convert input string to char array
        Arrays.sort(newTempArray); // sort tempArray
        String newSortedCipher = new String(newTempArray); // return new sorted string
        System.out.println("Sorted single character cipher string: " + newSortedCipher);
        System.out.println("");

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
            for (int j = 0; j < newSortedCipher.length(); j++) {
                //lets figure out P value. if value < 0 add 26.
                p = alphabet.get((newSortedCipher.charAt(j))) - i;
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
                multFreq = cipherTextFrequencyMap.get((newSortedCipher.charAt(j)));
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
        //System.out.println(Arrays.toString(mult)); //prints mult array

        System.out.println("FINAL RESULTS");
        for(int i = 0; i < mult.length;i++){
            System.out.println(i + " " + backwards.get(i) + " " + mult[i]);
        }
    }
}

//for ciphertext -> plaintext (DECRYPTION)
//find key then go backwards in alphabet

//for plaintext -> cipher text
//find key then go forwards in alphabet.