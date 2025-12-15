import java.util.List;

public class ArrayList {
    public static void main(String[] args) {
        // uses standard array under the hood
        // intial capacity is 10

        List<String> arr = new java.util.ArrayList<>();
        arr.add("a");
        arr.add("b");
        arr.add("c");
        arr.add("d");
        arr.add("e");

        System.out.println(arr.toString());

        // Removing (manipulating) the first item will result in O(N), because it will shify all the other items
//        arr.remove(0);
//        System.out.println(arr.toString());

        for (String i : arr) {
            System.out.println(i);
        }
    }
}