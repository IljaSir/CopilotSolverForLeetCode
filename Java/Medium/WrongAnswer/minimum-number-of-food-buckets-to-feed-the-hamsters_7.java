class Solution {
    public int minimumBuckets(String hamsters) {
        
        int n = hamsters.length();
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (hamsters.charAt(i) == 'H') {
                if (i > 0 && dp[i - 1] != -1) {
                    dp[i] = dp[i - 1];
                } else {
                    dp[i] = res++;
                }
            }
        }
        for (int i = n - 1; i >= 0; i--) {
            if (hamsters.charAt(i) == 'H') {
                if (i < n - 1 && dp[i + 1] != -1) {
                    if (dp[i] != -1 && dp[i] != dp[i + 1]) {
                        return -1;
                    }
                    dp[i] = dp[i + 1];
                } else {
                    if (dp[i] != -1) {
                        return -1;
                    }
                    dp[i] = res++;
                }
            }
        }
        return res;
    }
}