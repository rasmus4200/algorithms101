package challenges.classics;

import java.util.HashMap;

public class CaesarCipherSimple {

    //
    // This is a simple brute force first attempt that hard codes the shifting position,
    // and encrpyts everything with a simple HashMap lookup.
    //
    // Assumptions:
    // - cipher has offset x3
    // - only handles capital letters

    private HashMap<String, String> encryptMap;
    private HashMap<String, String> decryptMap;

    public CaesarCipherSimple() {
        encryptMap = createEncryptionMap();
        decryptMap = createDncryptionMap();
    }

    public String encrypt(String plainText) {
        StringBuilder cipherText = new StringBuilder();

        char[] letters = plainText.toCharArray();

        for (int i=0;i < letters.length; i++) {
            String encryptedLetter = " ";
            String letterToEncrypt = String.valueOf(letters[i]);

            if (!letterToEncrypt.equals(" ")) {
                encryptedLetter = encryptMap.get(letterToEncrypt);
            }

            cipherText.append(encryptedLetter);
        }

        return cipherText.toString();
    }

    public String decrypt(String plainText) {
        StringBuilder cipherText = new StringBuilder();

        char[] letters = plainText.toCharArray();

        for (int i=0;i < letters.length; i++) {
            String decryptedLetter = " ";
            String letterToDecrypt = String.valueOf(letters[i]);

            if (!letterToDecrypt.equals(" ")) {
                decryptedLetter = decryptMap.get(letterToDecrypt);
            }

            cipherText.append(decryptedLetter);
        }

        return cipherText.toString();
    }

    private HashMap<String, String> createEncryptionMap() {
        encryptMap = new HashMap<String, String>();
        encryptMap.put("A", "X");
        encryptMap.put("B", "Y");
        encryptMap.put("C", "Z");
        encryptMap.put("D", "A");
        encryptMap.put("E", "B");
        encryptMap.put("F", "C");
        encryptMap.put("G", "D");
        encryptMap.put("H", "E");
        encryptMap.put("I", "F");
        encryptMap.put("J", "G");
        encryptMap.put("K", "H");
        encryptMap.put("L", "I");
        encryptMap.put("M", "J");
        encryptMap.put("N", "K");
        encryptMap.put("O", "L");
        encryptMap.put("P", "M");
        encryptMap.put("Q", "N");
        encryptMap.put("R", "O");
        encryptMap.put("S", "P");
        encryptMap.put("T", "Q");
        encryptMap.put("U", "R");
        encryptMap.put("V", "S");
        encryptMap.put("W", "T");
        encryptMap.put("X", "U");
        encryptMap.put("Y", "V");
        encryptMap.put("Z", "W");

        return encryptMap;
    }

    private HashMap<String, String> createDncryptionMap() {
        decryptMap = new HashMap<String, String>();
        decryptMap.put("X","A");
        decryptMap.put("Y","B");
        decryptMap.put("Z","C");
        decryptMap.put("A","D");
        decryptMap.put("B","E");
        decryptMap.put("C","F");
        decryptMap.put("D","G");
        decryptMap.put("E","H");
        decryptMap.put("F","I");
        decryptMap.put("G","J");
        decryptMap.put("H","K");
        decryptMap.put("I","L");
        decryptMap.put("J","M");
        decryptMap.put("K","N");
        decryptMap.put("L","O");
        decryptMap.put("M","P");
        decryptMap.put("N","Q");
        decryptMap.put("O","R");
        decryptMap.put("P","S");
        decryptMap.put("Q","T");
        decryptMap.put("R","U");
        decryptMap.put("S","V");
        decryptMap.put("T","W");
        decryptMap.put("U","X");
        decryptMap.put("V","Y");
        decryptMap.put("W","Z" );

        return decryptMap;
    }

}