class Solution {
    public int minDeletionSize(String[] strs) {
        
        int n = strs.length;
        int m = strs[0].length();
        int[] dp = new int[m];
        Arrays.fill(dp, 1);
        int ans = 0;
        for (int j = 0; j < m; j++) {
            for (int i = 0; i < j; i++) {
                if (dp[i] == j - i && check(strs, i, j)) {
                    dp[j] = Math.max(dp[j], dp[i] + 1);
                }
            }
            ans = Math.max(ans, dp[j]);
        }
        return m - ans;
    }
    
    private boolean check(String[] strs, int i, int j) {
        for (String str : strs) {
            if (str.charAt(i) > str.charAt(j)) {
                return false;
            }
        }
        return true;
    }
}