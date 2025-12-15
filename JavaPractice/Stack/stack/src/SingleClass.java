public class SingleClass {   private int count;
    private static int[] stack = new int[20];

    public static  void main(String[] args) {

    }

    private void push(int n) {
        if (count == stack.length) {
            resize(2*stack.length);
        }

        stack[count] = n;
        count++;
    }

    public int pop() {
        if (count == 0) {
            return  0;
        }

        int t = stack[--count];
        if (count > 0 && count < stack.length/4) {
            resize(stack.length/2);
        }
        return t;
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

