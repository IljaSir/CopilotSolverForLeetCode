class Solution {
    public int minDeletionSize(String[] strs) {
        
        int n = strs.length;
        int m = strs[0].length();
        int[] dp = new int[m];
        Arrays.fill(dp, 1);
        int res = 0;
        for (int j = 0; j < m; j++) {
            for (int i = 0; i < j; i++) {
                if (isSorted(strs, i, j)) {
                    dp[j] = Math.max(dp[j], dp[i] + 1);
                }
            }
            res = Math.max(res, dp[j]);
        }
        return m - res;
    }
    private boolean isSorted(String[] strs, int i, int j) {
        for (String str : strs) {
            if (str.charAt(i) > str.charAt(j)) {
                return false;
            }
        }
        return true;
    }
}