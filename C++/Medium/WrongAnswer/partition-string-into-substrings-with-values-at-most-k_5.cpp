class Solution {
public:
    int minimumPartition(string s, int k) {
        
        int n = s.size();
        int dp[n];
        for (int i = 0; i < n; i++) dp[i] = INT_MAX;
        dp[0] = s[0] - '0';
        for (int i = 1; i < n; i++) {
            dp[i] = s[i] - '0';
            for (int j = i; j >= 1; j--) {
                if (dp[j - 1] == INT_MAX) continue;
                dp[i] = min(dp[i], dp[j - 1] + (s[j] - '0'));
            }
        }
        int res = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (dp[i] <= k) {
                res = i;
                break;
            }
        }
        if (dp[res] == INT_MAX) return -1;
        int ans = 0;
        for (int i = 0; i <= res; i++) {
            if (s[i] == '1') {
                ans++;
            }
        }
        return ans;
    }
};