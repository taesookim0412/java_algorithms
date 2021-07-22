package aa;

import java.util.Arrays;

public class ReverseWords {
    public static void main(String[] args) {
        ReverseWords obj = new ReverseWords();
        System.out.println(
                obj.reverseWords("Alice does not even like bob")
        );
    }
    public String reverseWords(String s){
        String[] strs = s.trim().split(" +");
        String[] strsReversed = new String[strs.length];
        for (int i = 0; i < strs.length; i++){
            strsReversed[i] = strs[strs.length - 1 - i];
        }
        return String.join(" ", strsReversed);
    }
}
