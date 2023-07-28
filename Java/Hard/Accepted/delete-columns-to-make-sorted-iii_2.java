class Solution {
    public int minDeletionSize(String[] strs) {
        
        int n = strs.length;
        int m = strs[0].length();
        int[] dp = new int[m];
        Arrays.fill(dp, 1);
        for (int j = 0; j < m; ++j) {
            for (int i = 0; i < j; ++i) {
                int ok = 1;
                for (int k = 0; k < n; ++k) {
                    if (strs[k].charAt(i) > strs[k].charAt(j)) {
                        ok = 0;
                        break;
                    }
                }
                if (ok == 1) {
                    dp[j] = Math.max(dp[j], dp[i] + 1);
                }
            }
        }
        return m - Arrays.stream(dp).max().getAsInt();
    }
}