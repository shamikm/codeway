package org.maj.sm.codility.bracket;

import java.util.Stack;

/**
 *
 * )()()(
 * @author shamik.majumdar
 */
public class Solution {

    public int solution(String S, int K) {
        Stack<Character> stack = new Stack<>();
        int i = 0;
        for (; i < S.length(); i++) {
            char c = S.charAt(i);
            if (c == '(' ) {
                stack.push(c);
            }else if (c == ')') {
                if (stack.size() > 0) {
                    char p = stack.peek();
                    if (p == '(' && c == ')') {
                        stack.pop();
                    }else {
                        if (p == ')') {
                            K--;
                            stack.pop();
                            stack.push('(');
                            stack.push(c);
                        }
                    }
                }else {
                    K--;
                    stack.push('(');
                }
            }
        }
        //lets look at the stacks now

        return i-stack.size();
    }

    public static void main(String... args){
        Solution solution = new Solution();
        System.out.println(solution.solution("()()()((",3));
    }
}
