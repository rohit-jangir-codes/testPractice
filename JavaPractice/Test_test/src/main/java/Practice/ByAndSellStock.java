package Practice;

public class ByAndSellStock {
    public static void main(String[] args) {

        ByAndSellStock obj = new ByAndSellStock();

        System.out.println ("best time to sell stock is : "+ obj.bestTimeToByAndSellStock(new int[] {7,1,5,3,6,4}));
    }

    public int bestTimeToByAndSellStock(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int p : prices) {
            if (p < minPrice) {
                minPrice = p;
            } else if (p - minPrice > maxProfit) {
                maxProfit = p - minPrice;
            }
        }

        return maxProfit;
    }
}
