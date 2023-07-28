class Solution {
public:
    string findTheString(vector<vector<int>>& lcp) {
        
        int n = lcp.size();
        vector<string> strs(n, "");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = lcp[i][j];
                if (i > 0) {
                    dp[i][j] = min(dp[i][j], dp[i - 1][j]);
                }
                if (j > 0) {
                    dp[i][j] = min(dp[i][j], dp[i][j - 1]);
                }
            }
        }
        int i = n - 1, j = n - 1;
        string res;
        while (i >= 0 && j >= 0) {
            if (i == 0 && j == 0) {
                if (dp[i][j] == 0) {
                    res.push_back('a');
                } else {
                    for (int k = 0; k < dp[i][j]; k++) {
                        res.push_back(res[k]);
                    }
                ans = strs[i];
            }
        }
        return    ;
    }
};