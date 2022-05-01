package datastructure;

import java.util.Stack;

public class StackBalancedBracket {

    public static void main(String... args){
        String s = "{[(])}";
        System.out.println(isBalanced(s));
    }

    public static String isBalanced(String s) {
        Stack<Character> stack = new Stack<>();
        for(Character ch : s.toCharArray()){
            if('[' == ch || '(' == ch || '{' == ch) {
                stack.push(ch);
                continue;
            }
            if(stack.isEmpty()){
                return "NO";
            }
            Character check;
            check = stack.pop();
            switch(ch){
                case ')':
                    if('[' == check || '{' == check)
                        return "NO";
                    break;
                case '}':
                    if('(' == check || '[' == check)
                        return "NO";
                    break;
                case ']':
                    if('{' == check || '(' == check)
                        return "NO";
                    break;
            }
        }

        if(!stack.isEmpty()){
            return "NO";
        }
        return "YES";

    }

}
