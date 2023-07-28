class Solution {
    public int minCost(String colors, int[] neededTime) {
        
        int n = colors.length();
        int[] dp = new int[n];
        int[] last = new int[26];
        Arrays.fill(last, -1);
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int c = colors.charAt(i) - 'a';
            dp[i] = neededTime[i];
            if (last[c] >= 0) dp[i] = Math.min(dp[i], dp[last[c]] + neededTime[i]);
            if (i > 0) dp[i] = Math.min(dp[i], dp[i-1]);
            last[c] = i;
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}