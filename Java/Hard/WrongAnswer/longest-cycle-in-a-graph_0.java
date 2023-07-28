class Solution {
    public int longestCycle(int[] edges) {
        
        int n = edges.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int j = i;
            int len = 0;
            while (edges[j] != -1) {
                if (dp[j] != -1) {
                    len += dp[j];
                    break;
                }
                len++;
                int t = edges[j];
                edges[j] = -1;
                j = t;
            }
            j = i;
            while (edges[j] != -1) {
                dp[j] = len--;
                j = edges[j];
            }
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}