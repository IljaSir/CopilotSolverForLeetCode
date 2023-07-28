class Solution {
    public int bestClosingTime(String customers) {
        
        int n = customers.length();
        int[] dp = new int[n+1];
        dp[n] = 0;
        for (int i = n-1; i >= 0; i--) {
            dp[i] = dp[i+1] + (customers.charAt(i) == 'Y' ? 1 : 0);
        }
        int penalty = dp[0];
        int best = 0;
        for (int i = 1; i <= n; i++) {
            int p = dp[i] + i;
            if (p < penalty) {
                penalty = p;
                best = i;
            }
        }
        return best;
    }
}