package org.maj.sm;

import com.google.common.collect.Sets;

import java.util.Set;
import java.util.Stack;

/**
 * Someone removes all the spaces from the sentence. It looks like
 * "therewego" instead of "there we go".
 * write an algo which can revert back the data
 * Assume you have access to a dictionary
 * @author shamik.majumdar
 */
public class NoSpace {
    private Set<String> dictionary;
    private String origString;

    public Set<String> getDictionary() {
        return dictionary;
    }

    public void setDictionary(Set<String> dictionary) {
        this.dictionary = dictionary;
    }

    public void setOrigString(String origString) {
        this.origString = origString;
    }

    public String getOrigStringIterative(){
        StringBuilder temp = new StringBuilder();
        StringBuilder result = new StringBuilder();
        Stack<Integer> matchedIndex = new Stack<>();
        matchedIndex.push(0);
        do {
            int i = matchedIndex.pop()+1;
            if (i != 0){
                temp.delete(0, temp.length());
                temp.append(origString.substring(0,i));
                result.delete(0,result.length());
            }
            for (; i < origString.toCharArray().length; i++) {
                char c = origString.charAt(i);
                temp.append(c);
                if (dictionary.contains(temp.toString())) {
                    matchedIndex.push(i);
                    result.append(temp);
                    result.append(" ");
                    temp.delete(0, temp.length());
                }
            }
        }while(temp.length() != 0);


        return result.toString();
    }


    public static void main(String... args){
        NoSpace noSpace = new NoSpace();
        noSpace.setDictionary(Sets.newHashSet("the","there","we","go"));
        noSpace.setOrigString("therewego");
        System.out.println(noSpace.getOrigStringIterative());
    }
}
