class Solution {
    public String stoneGameIII(int[] stoneValue) {
        
        int n = stoneValue.length;
        int[] dp = new int[n];
        dp[n - 1] = stoneValue[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            int sum = 0;
            dp[i] = Integer.MIN_VALUE;
            for (int j = i; j < i + 3 && j < n; j++) {
                sum += stoneValue[j];
                dp[i] = Math.max(dp[i], sum - dp[j + 1]);
            }
        }
        if (dp[0] > 0) return "Alice";
        if (dp[0] < 0) return "Bob";
        return "Tie";
    }
}