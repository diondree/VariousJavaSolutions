/*
 * Provides the solution to compressing a given string using the string's characters and consecutive occurences 
 */

import java.util.*;
/**
 *
 * @author diondreedwards
 */
public class CompressString {
    
    public static String compressString(String text) {
        int compressionSize = getCompressionSize(text);
        StringBuilder compression = new StringBuilder(compressionSize);
        int count = 0;
        
        for (int i = 0; i < text.length(); i++) {
            count++;
            if (i+1 >= text.length() || text.charAt(i) != text.charAt(i+1)) {
                compression.append(text.charAt(i));
                compression.append(count);
                count = 0;
            }
        }
        
        if (compression.length() < text.length()) {
            return compression.toString();
        } else {
            return text;
        }
    }
    
    public static int getCompressionSize(String text) {
        int count = 0;
        for (int i = 0; i < text.length(); i++) {
            if (i+1 >= text.length() || text.charAt(i) != text.charAt(i+1)) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String a = in.next();
        System.out.println(compressString(a));
    }
}