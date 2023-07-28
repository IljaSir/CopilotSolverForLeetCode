class Solution {
    public int maximumScore(int[] scores, int[][] edges) {
        
        int n = scores.length;
        int[] parents = new int[n];
        for (int i = 0; i < n; i++) {
            parents[i] = i;
        }
        for (int[] edge : edges) {
            int a = find(parents, edge[0]);
            int b = find(parents, edge[1]);
            if (a != b) {
                parents[a] = b;
            }
        }
        int[] dp = new int[n];
        int ans = -1;
        for (int i = n - 1; i >= 0; i--) {
            int p = find(parents, i);
            dp[p] = Math.max(dp[p], dp[i] + scores[i]);
            ans = Math.max(ans, dp[p]);
        }
        return ans;
    }
}