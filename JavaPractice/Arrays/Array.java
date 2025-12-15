public class Array {
    public static void main(String[] args) {
        int[] arr = new int[10];

        // insert the array index value
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }

        //Manipulate the index value which will result in O(1)

        arr[0] = 1000;

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

        // linear search
        // find 7 in the array

        // this will result in the O(N) time complexity. If we don't know the index of the element
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == 7) {
                System.out.println("Found 7 at the index: " + arr[i]);
            }
        }
    }
}