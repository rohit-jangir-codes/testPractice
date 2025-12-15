import java.util.Stack;

public class StackInJava {
    public  static void main(String[] args) {

        Stack<String> stack = new Stack<>();
        stack.push("1");
        stack.push("2");
        stack.push("3");
        stack.push("4");
        stack.push("5");
        stack.push("6");

        while(!stack.isEmpty()){
            System.out.println("from peel");
            System.out.println(stack.peek());
        }

        while(!stack.isEmpty()){
            System.out.println("from pop");
            System.out.println(stack.pop());
        }
    }
}
