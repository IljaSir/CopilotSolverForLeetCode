class Solution {
    public int minimumBuckets(String hamsters) {
        
        int n = hamsters.length();
        int[] dp = new int[n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (hamsters.charAt(i) == 'H') {
                count++;
                if (i > 0 && dp[i - 1] > 0) {
                    dp[i] = dp[i - 1] - 1;
                } else {
                    dp[i] = 1;
                }
            } else {
                if (i > 0) {
                    dp[i] = dp[i - 1];
                }
            }
        }
        for (int i = n - 1; i >= 0; i--) {
            if (hamsters.charAt(i) == 'H') {
                if (i < n - 1 && dp[i + 1] > 0) {
                    dp[i] = Math.max(0, dp[i + 1] - 1);
                } else {
                    dp[i] = Math.max(0, dp[i] - 1);
                }
            }
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (hamsters.charAt(i) == 'H' && dp[i] == 0) {
                return -1;
            }
            res += dp[i];
        }
        return res;
    }
}