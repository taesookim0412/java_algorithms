package playground;


import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class byte_to_string {
    public static void main(String[] args) {
        byte[] nullEnding = new byte[24];
        Arrays.fill(nullEnding, (byte) 0);
        String emptyString = new String(nullEnding, StandardCharsets.UTF_8);
        String s = "{ Hello, World! }" + emptyString;

        byte_to_string thisPlayground = new byte_to_string();
        String newS = "";

        long currentTime = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            newS = thisPlayground.createString(s);
        }
        //18ms without InputStream, 28ms with InputStream
        System.out.println(System.currentTimeMillis() - currentTime);
        System.out.println(newS);

        long currentTime2 = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            newS = thisPlayground.createStringFromJDK(s);
        }
        //10ms without InputStream, 19ms with InputStream
        System.out.println(System.currentTimeMillis() - currentTime2);
        System.out.println(newS);


    }

    public String createString(String s) {
        StringBuilder newStr = new StringBuilder(32);
        try {
            InputStream inputStream = createInputStream(s);
            while (inputStream.available() != 0) {
                int data = inputStream.read();
                if (data == 0) {
                    break;
                }
                newStr.append((char) data);
            }
            return newStr.toString();
        }
        catch (Exception e){

        }
        return "";
    }

    public String createStringFromJDK(String s) {
        InputStream inputStream = createInputStream(s);
        byte[] byteArr = new byte[32];
        try {
            inputStream.read(byteArr);
            int i = byteArr.length - 1;
            while (i >= 0) {
                if (byteArr[i] != 0) {
                    break;
                }
                i -= 1;
            }
            byte[] arrCpy = Arrays.copyOfRange(byteArr, 0, i + 1);
            return new String(arrCpy, StandardCharsets.UTF_8);
        }
        catch (Exception e){

        }
        return "";
    }

    public InputStream createInputStream(String s) {
        return new ByteArrayInputStream(s.getBytes());
    }
}
