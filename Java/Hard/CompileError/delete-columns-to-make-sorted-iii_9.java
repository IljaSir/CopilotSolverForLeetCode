class Solution {
    public int minDeletionSize(String[] strs) {
        
        int n = strs.length;
        int m = strs[0].length();
        int[] dp = new int[m];
        int ans = 0;
        for (int j = 0; j < m; ++j) {
            dp[j] = 1;
            for (int i = 0; i < j; ++i)
                if (isSorted(strs, i, j))
                    dp[j] = Math.max(dp[j], dp[i] + 1);
            ans = Math.max(ans, dp[j]);
        }
        return m - ans;
    }
}