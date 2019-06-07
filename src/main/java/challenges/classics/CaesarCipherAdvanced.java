package challenges.classics;

public class CaesarCipherAdvanced {

    //
    // This is a more algorithmic way of solving the Caesar Cipher using the following equations
    //
    // E(x) = (x + n) mod 26
    // D(x) = (x - n) mod 26
    //
    // x = letter
    // n = offset

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

        StringBuilder cipherText = new StringBuilder();

        for (int i = 0; i < plainText.length(); i++) { // O(n)
            char charToEncrypt = plainText.charAt(i);
            char replaceVal = ' ';

            if (charToEncrypt != ' ') {
                int x = ALPHABET.indexOf(charToEncrypt);
                int keyVal = (n + x) % 26;
                replaceVal = ALPHABET.charAt(keyVal);
            }

            cipherText.append(replaceVal); // O(1) because using StringBuffer
        }

        return cipherText.toString();

        // Runtime: Originally I coded this concatenating the result +=
        //
        //             cipherText += replaceVal;
        //
        // which was O(n^2) or quadratic. This isn't great for performance.
        // By switching to a StringBuilder, we get O(1) performance when combining the strings.
        // Which makes the overall runtime of the operation O(n) because of the for loop.
        //
    }

    public String decrypt(String cipherText, int n) {

        StringBuilder plainText = new StringBuilder();

        for (int i = 0; i < cipherText.length(); i++) {
            char charToDecrypt = cipherText.charAt(i);
            char replaceVal = ' ';

            if (charToDecrypt != ' ') {
                int x = ALPHABET.indexOf(charToDecrypt);
                int keyVal = (x - n) % 26;

                if (keyVal < 0) {
                    keyVal = ALPHABET.length() + keyVal;
                }

                replaceVal = ALPHABET.charAt(keyVal);
            }

            plainText.append(replaceVal);
        }

        return plainText.toString();
    }

}