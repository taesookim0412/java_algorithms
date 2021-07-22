package aa;

import java.util.ArrayList;
import java.util.HashMap;

public class ValidParentheses {
    public static void main(String[] args){
        ValidParentheses obj = new ValidParentheses();
        System.out.println(obj.isValid("()[]{}"));
        System.out.println(obj.isValid("(]"));


    }
    public boolean isValid(String s){
        HashMap<Character, Character> parenMap = new HashMap<Character, Character>();
        parenMap.put(')', '(');
        parenMap.put('}', '{');
        parenMap.put(']', '[');
        ArrayList<Character> openStack = new ArrayList<Character>();
        for (int i = 0; i < s.length(); i++){
            char stringChar = s.charAt(i);
            if (stringChar == ')' || stringChar == '}' || stringChar == ']'){
                if (openStack.size() == 0 || openStack.get(openStack.size() - 1) != parenMap.get(stringChar)) {
                    return false;
                }
                openStack.remove(openStack.size() - 1);
            }
            else{
                openStack.add(stringChar);
            }
        }
        return openStack.size() == 0;
    }
}
