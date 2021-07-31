package playground;


import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class byte_to_string {
    public static void main(String[] args) {
        byte[] nullEnding = new byte[24];
        Arrays.fill(nullEnding, (byte) 0);
        String emptyString = new String(nullEnding, StandardCharsets.UTF_8);
        String s = "{ Hello, World! }" + emptyString;

        byte[] byteArr = s.getBytes(StandardCharsets.UTF_8);
        byte_to_string thisPlayground = new byte_to_string();
        String newS = "";

        long currentTime = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++){
            newS = thisPlayground.createString(byteArr);
        }
        //18ms
        System.out.println(System.currentTimeMillis() - currentTime);
        System.out.println(newS);

        long currentTime2 = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++){
            newS = thisPlayground.createStringFromJDK(byteArr);
        }
        //10ms
        System.out.println(System.currentTimeMillis() - currentTime2);
        System.out.println(newS);



    }
    public String createString(byte[] byteArr){
        StringBuilder newStr = new StringBuilder();
        for (int i = 0; i < byteArr.length; i++){
            if (byteArr[i] == 0){
                break;
            }
            newStr.append((char) byteArr[i]);
        }
        return newStr.toString();
    }
    public String createStringFromJDK(byte[] byteArr){
        int i = byteArr.length - 1;
        while (i >= 0){
            if (byteArr[i] != 0){
                break;
            }
            i -= 1;
        }
        byte[] arrCpy = Arrays.copyOfRange(byteArr, 0, i + 1);
        return new String(arrCpy, StandardCharsets.UTF_8);
    }
}
