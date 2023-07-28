class Solution {
    public int minDeletionSize(String[] strs) {
        
        int n = strs.length;
        int m = strs[0].length();
        int[] dp = new int[m];
        Arrays.fill(dp, 1);
        for (int i = 1; i < m; ++i) {
            for (int j = 0; j < i; ++j) {
                boolean isSorted = true;
                for (int k = 0; k < n; ++k) {
                    if (strs[k].charAt(j) > strs[k].charAt(i)) {
                        isSorted = false;
                        break;
                    }
                }
                if (isSorted) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        return m - Arrays.stream(dp).max().getAsInt();
    }
}