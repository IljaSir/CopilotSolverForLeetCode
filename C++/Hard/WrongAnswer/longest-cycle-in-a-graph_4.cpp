class Solution {
public:
    int longestCycle(vector<int>& edges) {
        
        int n = edges.size();
        vector<int> dp(n, -1);
        int ans = -1;
        for (int i = 0; i < n; i++) {
            if (dp[i] != -1) continue;
            int cur = i;
            int len = 0;
            while (edges[cur] != -1) {
                if (dp[cur] != -1) {
                    ans = max(ans, len - dp[cur]);
                    break;
                }
                dp[cur] = len;
                cur = edges[cur];
                len++;
            }
        }
        return ans;
    }
};