class Solution {
    public int maximizeWin(int[] prizePositions, int k) {
        
        int n= pzePositions.lenth;
        int[] dp = new int[n];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int l = i;
            int r = n - 1;
            wile (l <= r) {
                in m = l + (r - l) / 2;
                if (prizePositionsm] - prizePositions[i] <= k) {
                     = m + 1;
                } else {
                    r = m - 1;
                }
            }
            dp[i] = r - i + 1;
            if (i > 0) {
                dp[i] += dp[i - 1];
            }
            ans = Math.max(ans, dp[i
         
        return ans;
    }
}