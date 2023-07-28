class Solution {
    public int minDeletionSize(String[] strs) {
        
        int n = strs.length;
        int m = strs[0].length();
        int[] dp = new int[n];
        int res = 0;
        for (int i = 0; i < m; i++) {
            int[] ndp = new int[n];
            for (int j = 0; j < n; j++) {
                ndp[j] = dp[j] + 1;
                for (int k = 0; k < j; k++) {
                    if (strs[k].charAt(i) <= strs[j].charAt(i)) {
                        ndp[j] = Math.min(ndp[j], dp[k]);
                    }
                }
            }
            dp = ndp;
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < n; j++) {
                min = Math.min(min, dp[j]);
            }
            if (min == n) {
                res++;
            }
        }
        return res;
    }
}