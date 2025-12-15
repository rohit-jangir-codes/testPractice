//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Stack<String> stack = new Stack<>();
        stack.push("a");
        stack.push("b");
        stack.push("c");

        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
        }
}