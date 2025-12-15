public class StackArrayApp {


    private int count;
    private int[] stack = new int[20];

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

    public void push(int n) {
        if (count == stack.length) {
            resize(2*stack.length);
        }

        stack[count] = n;
        count++;
    }

    public int pop() {
        if (count == 0) {
            return  null;
        } 

        int t = stack[--count];
        if (count > 0 && count < stack.length/4) {
            resize(stack.length/2);
        }
        returnt;
    }

    public void resize(int newLingth) {
        int[] temp = new int[newLingth];
        for(int i = 0; i < count; i++) {
            temp[i] = stack[i];
        }

        stack = temp;
    }

    public boolean isEmpty() {
        return count == 0;
    }

}
