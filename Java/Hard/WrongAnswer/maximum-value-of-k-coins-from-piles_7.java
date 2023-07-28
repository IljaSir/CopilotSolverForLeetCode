class Solution {
    public int maxValueOfCoins(List<List<Integer>> piles, int k) {
        
        int[] coins = new int[piles.size() * 3];
        int i = 0;
        for (List<Integer> pile : piles) {
            for (int c : pile) {
                coins[i++] = c;
            }
        }
        Arrays.sort(coins);
        int ans = 0;
        for (i = coins.length - 2; k > 0; i -= 2, k--) {
            ans += coins[i];
        }
        return ans;
    }
}