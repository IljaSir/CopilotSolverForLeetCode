class Solution {
    public int longestPath(int[] parent, String s) {
        
        int n = parent.length;
        int[] dp = new int[n];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int[] cnt = new int[26];
            int node = i;
            while (node != -1) {
                int c = s.charAt(node) - 'a';
                if (cnt[c] > 0) {
                    break;
                }
                cnt[c] = dp[node] + 1;
                ans = Math.max(ans, cnt[c]);
                node = parent[node];
            }
            for (int j = 0; j < 26; j++) {
                dp[i] = Math.max(dp[i], cnt[j]);
            }
        }
        return ans;
    }
}