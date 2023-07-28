class Solution {
    public int longestCycle(int[] edges) {
        
        int n = edges.length;
        int[] dp = new int[n];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int cur = i;
            int curLen = 0;
            while (edges[cur] != -1) {
                curLen++;
                int next = edges[cur];
                edges[cur] = -1;
                cur = next;
                if (dp[cur] != 0) {
                    curLen += dp[cur];
                    break;
                }
            }
            ans = Math.max(ans, curLen);
            dp[i] = curLen;
        }
        return ans < 3 ? -1 : ans;
    }
}