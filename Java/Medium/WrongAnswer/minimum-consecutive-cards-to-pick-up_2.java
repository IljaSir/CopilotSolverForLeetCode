class Solution {
    public int minimumCardPickup(int[] cards) {
        
        int[] count = new int[1000001];
        int max = 0;
        for (int card : cards) {
            count[card]++;
            max = Math.max(max, count[card]);
        }
        if (max >= cards.length / 2 + 1) {
            return -1;
        }
        int[] dp = new int[max + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int card : cards) {
            for (int i = max; i > 0; i--) {
                if (dp[i - 1] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[i - 1] + 1);
                }
            }
        }
        return dp[max];
    }
}