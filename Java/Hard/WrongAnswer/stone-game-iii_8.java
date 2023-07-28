class Solution {
    public String stoneGameIII(int[] stoneValue) {
        
        int[] dp = new int[3];
        int n = stoneValue.length;
        for (int i = n - 1; i >= 0; i--) {
            dp[i % 3] = Integer.MIN_VALUE;
            int sum = 0;
            for (int k = 0; k < 3 && i + k < n; k++) {
                sum += stoneValue[i + k];
                dp[i % 3] = Math.max(dp[i % 3], sum - dp[(i + k + 1) % 3]);
            }
        }
        if (dp[0] > 0) return "Alice";
        if (dp[0] < 0) return "Bob";
        return "Tie";
    }
}