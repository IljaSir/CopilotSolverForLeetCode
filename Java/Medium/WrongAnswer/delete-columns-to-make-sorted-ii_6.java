class Solution {
    public int minDeletionSize(String[] strs) {
        
        int n = strs.length;
        int m = strs[0].length();
        int[] dp = new int[m];
        int res = 0;
        for (int i = 0; i < m; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                boolean isSorted = true;
                for (int k = 0; k < n; k++) {
                    if (strs[k].charAt(j) > strs[k].charAt(i)) {
                        isSorted = false;
                        break;
                    }
                }
                if (isSorted) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return m - res;
    }
}