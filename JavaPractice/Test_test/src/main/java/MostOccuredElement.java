import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class MostOccuredElement {

    public static void main(String[] args) {
        MostOccuredElement mostOccuredElement = new MostOccuredElement();
        int[] nums = mostOccuredElement.returnMostOccuredElement(new int[]{2,2,2,1,1,8,8,3,3,3,3}, 2);

        System.out.println("most occured elements are : ");
        for (int n : nums) {
            System.out.println(n);
        }
    }

    public int[] returnMostOccuredElement(int[] arr, int k) {
        Map<Integer, Integer> freq = new HashMap<>();

        for (int n : arr) {
            freq.put(n, freq.getOrDefault(n, 0) + 1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> freq.get(a) - freq.get(b));

        for (int key : freq.keySet()) {
            pq.add(key);
            if (pq.size() > k) {
                pq.poll();
            }
        }

        int[] res = new int[k];
        for (int i = k -1 ; i >= 0; i--) {
            res[i] = pq.poll();
        }

        return res;
    }
}
