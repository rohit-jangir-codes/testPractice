public class StackArrayApp {

    public static  void main(String[] args) {
        StackArray<Integer> stack = new StackArray<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);
        stack.push(7);
        stack.push(8);
        stack.push(9);
        stack.push(10);

        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }


    }
}
