class Solution {
    public int longestPath(int[] parent, String s) {
        
        int n = parent.length;
        int[] dp = new int[n];
        int[] dp2 = new int[n];
        int ans = 0;
        for (int i = n - 1; i >= 0; i--) {
            int max = 0;
            int max2 = 0;
            for (int j = i + 1; j < n; j++) {
                if (parent[j] == i) {
                    if (s.charAt(j) != s.charAt(i)) {
                        if (dp[j] >= max) {
                            max2 = max;
                            max = dp[j];
                        } else if (dp[j] > max2) {
                            max2 = dp[j];
                        }
                    }
                }
            }
            dp[i] = max + 1;
            dp2[i] = max2 + 1;
            ans = Math.max(ans, dp[i] + max2);
        }
        return ans;
    }
}