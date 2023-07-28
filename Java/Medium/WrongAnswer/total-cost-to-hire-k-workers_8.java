class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        
        Arrays.sort(costs);
        long[] dp = new long[candidates + 1];
        long[] sum = new long[candidates + 1];
        long res = Long.MAX_VALUE;
        for (int i = 1; i <= k; i++) {
            for (int j = 1; j <= candidates; j++) {
                dp[j] = sum[j - 1] + costs[i - 1];
                sum[j] = sum[j - 1] + dp[j];
            }
            res = Math.min(res, dp[candidates]);
        }
        return res;
    }
}