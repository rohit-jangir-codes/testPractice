//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        // find the max (highest) item in the stack
/*

        MaxInStackProblem maxInStack = new MaxInStackProblem();
        maxInStack.push(10);
        maxInStack.push(20);
        maxInStack.push(330);
        maxInStack.push(40);
        maxInStack.push(510);
        maxInStack.push(6);
        maxInStack.push(7);

        System.out.println(maxInStack.getMaxItem());*/


        // To test QueuesUsingStacks

        QueuesUsingStacks queuesUsingStacks = new QueuesUsingStacks();

        queuesUsingStacks.enqueue(1);
        queuesUsingStacks.enqueue(2);
        queuesUsingStacks.enqueue(3);
        queuesUsingStacks.enqueue(4);
        queuesUsingStacks.enqueue(5);
        queuesUsingStacks.enqueue(6);


        System.out.println(queuesUsingStacks.dequeue());
        System.out.println(queuesUsingStacks.dequeue());
        queuesUsingStacks.enqueue(7);
        System.out.println(queuesUsingStacks.dequeue());
        System.out.println(queuesUsingStacks.dequeue());
        queuesUsingStacks.enqueue(8);
        System.out.println(queuesUsingStacks.dequeue());

    }
}