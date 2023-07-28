class Solution {
public:
    int minimumPartition(string s, int k) {
        
        int n = s.size();
        vector<int> num(n+1);
        for (int i = 1; i <= n; ++i) {
            num[i] = num[i-1] * 10 + s[i-1] - '0';
            if (num[i] > k) return -1;
        }
        vector<int> dp(n+1, n);
        dp[0] = 0;
        for (int i = 1; i <= n; ++i) {
            int cur = 0;
            for (int j = i; j >= 1; --j) {
                cur = cur * 10 + s[j-1] - '0';
                if (cur > k) break;
                dp[i] = min(dp[i], dp[j-1] + 1);
            }
        }
        return dp[n];
    }
};