package org.maj.sm;

import java.util.Arrays;

/**
 *
 * Find out the longest repeated common sub-string(overlapped) in a string.
 * For example:- mystr = banana
 * The "ana" is the common overlapped sub-string is been used 2 times.</p>
 * @author shamik.majumdar
 */
public class LRS {
    public static String lrs(String s){
        //Step 1 : find the suffix
        String[] suffiexes = new String[s.length()];
        for (int i=0; i < s.length();i++){
            suffiexes[i] = s.substring(i);
        }
        // Step 2 : Sort the suffixes
        Arrays.sort(suffiexes);

        //Step 3 : find the longest match
        String longestMatch = "";
        for (int i=0; i < s.length() -1 ; i++){
            String temp = lcp(suffiexes[i],suffiexes[i+1]);
            longestMatch = temp.length() > longestMatch.length() ? temp : longestMatch;
        }

        return longestMatch;
    }

    private static String lcp(String s1, String s2) {
        int len = Math.min(s1.length(),s2.length());
        int index = 0;
        while (index < len){
            if (s1.charAt(index) != s2.charAt(index)){
                break;
            }else {
                index++;
            }
        }
        return s1.substring(0,index);
    }
}
