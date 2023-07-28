class Solution {
public:
    int maxCount(vector<int>& banned, int n, int maxSum) {
        
        vector<int> dp(maxSum + 1);
        dp[0] = 1;
        for (int i = 1; i <= n; ++i) {
            if (find(banned.begin(), banned.end(), i) != banned.end()) continue;
            for (int j = maxSum; j >= i; --j) {
                dp[j] += dp[j - i];
            }
        }
        return dp[maxSum];
    }
};