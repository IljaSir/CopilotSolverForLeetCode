class Solution {
    public int minDeletionSize(String[] strs) {
        
        int n = strs.length;
        int m = strs[0].length();
        int[] dp = new int[m];
        Arrays.fill(dp, 1);
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < i; j++) {
                if (isSorted(strs, j, i)) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return m - res;
    }

    private boolean isSorted(String[] strs, int start, int end) {
        for (String str : strs) {
            for (int i = start; i < end; i++) {
                if (str.charAt(i) > str.charAt(i + 1)) {
                    return false;
                }
            }
        }
        return true;
    }
}