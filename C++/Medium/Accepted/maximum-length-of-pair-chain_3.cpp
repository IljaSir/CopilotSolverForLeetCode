class Solution {
public:
    int findLongestChain(vector<vector<int>>& pairs) {
        
        int n = pairs.size();
        if (n == 0) return 0;
        sort(pairs.begin(), pairs.end());
        int dp[n];
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (pairs[i][0] > pairs[j][1]) {
                    dp[i] = max(dp[i], dp[j] + 1);
                }
            }
        }
        return dp[n - 1];
    }
};