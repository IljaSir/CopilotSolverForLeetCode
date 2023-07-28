class Solution {
    public int maxStarSum(int[] vals, int[][] edges, int k) {
        
        int n = vals.length;
        int[] dp = new int[n];
        for(int i = 0; i < n; i++) dp[i] = vals[i];
        for(int i = 0; i < edges.length; i++) {
            int[] edge = edges[i];
            int a = edge[0];
            int b = edge[1];
            if(a > b) {
                int t = a;
                a = b;
                b = t;
            }
            dp[b] = Math.max(dp[b], dp[a] + vals[b]);
        }
        Arrays.sort(dp);
        int ans = 0;
        for(int i = n - 1; i >= n - 1 - k; i--) {
            ans += dp[i];
        }
        return ans;
    }
}