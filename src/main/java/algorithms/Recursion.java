package algorithms;

public class Recursion {


    public String stripZeros(String text) {
        if (text.startsWith("0")) {
            String substring = text.substring(1);
            String newString = stripZeros(substring);
            return newString;
        }
        return text; // nothing left to strip. Return!
    }

}
