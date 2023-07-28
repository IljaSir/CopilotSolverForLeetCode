class Solution {
public:
    int minTaps(int n, vector<int>& ranges) {
        
        int dp[n + 1];
        memset(dp, 0, sizeof(dp));
        for (int i = 0; i < ranges.size(); i++) {
            int l = max(0, i - ranges[i]);
            int r = min(n, i + ranges[i]);
            dp[l] = max(dp[l], r);
        }
        int ans = 0;
        int last = 0;
        int cur = 0;
        for (int i = 0; i < n; i++) {
            cur = max(cur, dp[i]);
            if (i == last) {
                ans++;
                last = cur;
            }
            if (last >= n) {
                return ans;
            }
        }
        return last >= n ? ans : -1;
    }
};