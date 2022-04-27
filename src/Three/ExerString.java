package Three;

import java.util.ArrayList;

public class ExerString {
    public static void main(String[] args) {

        String str = "asdsa";
        System.out.println(isPalindrom(str));

    }

    public static String getLongestString(ArrayList<String> array){
        if(array.size() == 0) return null;
        String resultString = "";
        for (String str: array) {
            if(resultString.length()<str.length()) resultString = str;
        }
        return resultString;
    }

    public static boolean isPalindrom(String string){

        for (int i = 0; i < string.length(); i++){
            if (i > (string.length()-1-i)) return true;
            if (i == (string.length()-1-i)) return true;
            if ((string.charAt(i) != string.charAt(string.length()-1-i))) return false;
        }
        return true;
    }
}
