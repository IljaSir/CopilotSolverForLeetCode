class Solution {
    public int minDeletionSize(String[] strs) {
        
        int n = strs.length;
        int m = strs[0].length();
        int[] dp = new int[m];
        Arrays.fill(dp, 1);
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < i; j++) {
                int k = 0;
                for (; k < n; k++) {
                    if (strs[k].charAt(j) > strs[k].charAt(i)) {
                        break;
                    }
                }
                if (k == n) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return m - res;
    }
}