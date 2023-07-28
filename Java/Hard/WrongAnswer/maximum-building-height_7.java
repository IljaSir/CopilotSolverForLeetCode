class Solution {
    public int maxBuilding(int n, int[][] restrictions) {
        
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        for (int[] r : restrictions)
            dp[r[0]] = r[1];
        for (int i = 1; i <= n; i++) {
            if (dp[i] == -1) continue;
            dp[i] = Math.min(dp[i], i-1);
        }
        for (int i = 1; i <= n; i++) {
            if (dp[i] == -1) continue;
            dp[i] = Math.min(dp[i], dp[i-1]+1);
        }
        for (int i = n-1; i >= 1; i--) {
            if (dp[i] == -1) continue;
            dp[i] = Math.min(dp[i], dp[i+1]+1);
        }
        int ans = 0;
        for (int i = 2; i <= n; i++) {
            if (dp[i] == -1) continue;
            ans = Math.max(ans, (dp[i-1]+dp[i]+i-i)/2);
        }
        return ans;
    }
}