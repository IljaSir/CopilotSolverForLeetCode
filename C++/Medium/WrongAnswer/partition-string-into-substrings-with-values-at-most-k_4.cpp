class Solution {
public:
    int minimumPartition(string s, int k) {
        
        int n = s.size();
        vector<int> dp(n + 1);
        for (int i = 0; i < n; ++i) {
            int mx = 0, mn = 10;
            for (int j = i; j < n; ++j) {
                mx = max(mx, s[j] - '0');
                mn = min(mn, s[j] - '0');
                if (mx - mn > k) break;
                dp[j + 1] = max(dp[j + 1], dp[i] + 1);
            }
        }
        return dp[n];
    }
};