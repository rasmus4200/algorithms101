package questions.classics;

import java.util.HashMap;

public class CaesarCipherAdvanced {

    //
    // This is a more algorithmic way of solving the Caesar Cipher using the following equations
    //
    // E(x) = (x + n) mod 26
    // D(x) = (x - n) mod 26
    //
    // What these equations basically say is, you can take any given letter, shift it by it's offset, and then
    // modulus 26 that result (25 letters in the alphabet).
    //
    // By applying this equation, we can come up with a more generic cipher algorithm, that encrypts and decrypts
    // for any generic offset (n).
    //
    // https://en.wikipedia.org/wiki/Caesar_cipher
    // http://www.sanfoundry.com/java-program-implement-caesar-cypher/ (based on)

    // Assumption: Upper case only

    public static final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public CaesarCipherAdvanced() {
    }

    public String encrypt(String plainText, int n) {

        String cipherText = "";

        for (int i = 0; i < plainText.length(); i++)
        {
            char charToEncrypt = plainText.charAt(i);
            char replaceVal = ' ';

            if (charToEncrypt != ' ') {
                int x = ALPHABET.indexOf(plainText.charAt(i));
                int keyVal = (n + x) % 26;
                replaceVal = ALPHABET.charAt(keyVal);
            }

            cipherText += replaceVal;
        }

        return cipherText.toString();
    }

    public String decrypt(String cipherText, int n) {

        String plainText = "";

        for (int i = 0; i < cipherText.length(); i++)
        {
            char charToDecrypt = cipherText.charAt(i);
            char replaceVal = ' ';

            if (charToDecrypt != ' ') {
                int x = ALPHABET.indexOf(cipherText.charAt(i));
                int keyVal = (x - n) % 26;

                if (keyVal < 0)
                {
                    keyVal = ALPHABET.length() + keyVal;
                }

                replaceVal = ALPHABET.charAt(keyVal);
            }

            plainText += replaceVal;
        }

        return plainText;
    }

    // For an example of how to handle uppercase & lowercase:
    // https://www.geeksforgeeks.org/caesar-cipher/
}