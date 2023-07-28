class Solution {
    public int minDeletionSize(String[] strs) {
        
        int n = strs.length;
        int m = strs[0].length();
        int[] dp = new int[m];
        Arrays.fill(dp, 1);
        for (int j = 1; j < m; j++) {
            for (int i = 0; i < j; i++) {
                boolean sorted = true;
                for (int k = 0; k < n; k++) {
                    if (strs[k].charAt(i) > strs[k].charAt(j)) {
                        sorted = false;
                        break;
                    }
                }
                if (sorted) {
                    dp[j] = Math.max(dp[j], dp[i] + 1);
                }
            }
        }
        return m - Arrays.stream(dp).max().getAsInt();
    }
}