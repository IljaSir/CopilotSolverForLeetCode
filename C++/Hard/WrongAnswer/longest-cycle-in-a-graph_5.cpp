class Solution {
public:
    int longestCycle(vector<int>& edges) {
        
        int n = edges.size();
        vector<int> dp(n, -1);
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            int j = i;
            int cur = 0;
            while (edges[j] != -1) {
                if (dp[j] != -1) {
                    cur += dp[j];
                    break;
                }
                int k = edges[j];
                edges[j] = -1;
                j = k;
                ++cur;
            }
            if (j == i && cur > 0) {
                ans = max(ans, cur);
            }
            j = i;
            while (dp[j] == -1) {
                dp[j] = cur--;
                if (edges[j] == -1) break;
                j = edges[j];
            }
        }
        return ans == n ? -1 : ans;
    }
};