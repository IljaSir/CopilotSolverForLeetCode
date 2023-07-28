class Solution {
    public int maxCount(int[] banned, int n, int maxSum) {
        
        int[] dp = new int[maxSum + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        for (int i = 1; i <= maxSum; i++) {
            for (int j = 1; j <= n; j++) {
                if (i - j >= 0 && dp[i - j] != -1) {
                    boolean found = false;
                    for (int k = 0; k < banned.length; k++) {
                        if (banned[k] == j) {
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        dp[i] = Math.max(dp[i], dp[i - j] + 1);
                    }
                }
            }
        }
        return dp[maxSum];
    }
}