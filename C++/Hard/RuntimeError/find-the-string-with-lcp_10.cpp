class Solution {
public:
    string findTheString(vector<vector<int>>& lcp) {
        
        int n = lcp.size();
        vector<string> dp(n, "");
        dp[0] = string(1, 'a');
        for (int i = 1; i < n; ++i) {
            int j = i - 1;
            while (j >= 0 && lcp[i][j] == lcp[i][i-1]) --j;
            dp[i] = dp[j] + string(1, 'a' + i - j - 1);
        }
        return dp[n-1];
    }
};