class Solution {
    public long minimumMoney(int[][] transactions) {
        
        long[] dp = new long[transactions.length];
        for (int i = 0; i < transactions.length; i++) {
            dp[i] = transactions[i][0] + transactions[i][1];
        }
        Arrays.sort(dp);
        long ans = 0;
        for (int i = 0; i < transactions.length; i++) {
            ans += dp[i];
            if (ans < transactions[i][0]) {
                ans = transactions[i][0];
            }
        }
        return ans;
    }
}