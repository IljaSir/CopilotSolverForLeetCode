class Solution {
    public String stoneGameIII(int[] stoneValue) {
        
        int n = stoneValue.length;
        int[] dp = new int[n+1];
        for (int i = n-1; i >= 0; i--) {
            dp[i] = Integer.MIN_VALUE;
            int sum = 0;
            for (int j = i; j < n && j < i+3; j++) {
                sum += stoneValue[j];
                dp[i] = Math.max(dp[i], sum - dp[j+1]);
            }
        }
        if (dp[0] == 0) return "Tie";
        return dp[0] > 0 ? "Alice" : "Bob";
    }
}