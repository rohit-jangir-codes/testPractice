package Practice;

/*Problem statement
Given string containing characters '(', ')', '{', '}', '[' ,']', determine if input string is valid: brackets
must close in correct order and type.
What interviewer tests
Stack usage and matching parentheses logic.
Approach (optimal)
Use a Stack. Push expected closing bracket when encountering opening bracket. When
encountering a closing bracket, check if it matches top of stack.
Algorithm (step-by-step)
• If length odd -> invalid
• Create stack Deque<Character> st = new ArrayDeque<>()
• For each char c:
o if c is '(', push ')'; '[' -> push ']' ; '{'-> push '}'
o else if stack is empty or c != stack.pop() return false
        • After loop, return stack.isEmpty()*/

import java.util.ArrayDeque;
import java.util.Deque;

public class ValidParanthesis {

    public static void main(String[] args) {
        ValidParanthesis validParanthesis = new ValidParanthesis();

        System.out.println("is this para string valid? : "+ validParanthesis.isSo(validParanthesis.isValid("()[]{}")));
    }

    public String isSo(boolean val) {
        return val?"YES":"NO";
    }

    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();

        for(char c : s.toCharArray()){
            if(c == '(') {
                stack.push(')');
            } else if(c == '{') {
                stack.push('}');
            } else if(c == '[') {
                stack.push(']');
            }
            // If it's a closing bracket, check if it matches the top of the stack
            else if(stack.isEmpty() || stack.pop() != c) {
                return false;
            }
        }

        return stack.isEmpty();
    }
}
