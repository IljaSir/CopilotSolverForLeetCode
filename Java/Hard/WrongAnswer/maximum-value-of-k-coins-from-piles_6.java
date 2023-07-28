class Solution {
    public int maxValueOfCoins(List<List<Integer>> piles, int k) {
        
        int n = piles.size();
        int m = piles.get(0).size();
        int[] coins = new int[n * m];
        int index = 0;
        for (List<Integer> pile : piles) {
            for (int coin : pile) {
                coins[index++] = coin;
            }
        }
        Arrays.sort(coins);
        int total = 0;
        for (int i = coins.length - 2; i >= coins.length - k; i -= 2) {
            total += coins[i];
        }
        return total;
    }
}