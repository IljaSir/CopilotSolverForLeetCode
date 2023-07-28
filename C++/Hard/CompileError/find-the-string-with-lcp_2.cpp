class Solution {
public:
    string findTheString(vector<vector<int>>& lcp) {
        
        int n = lcp.size();
        vector<vector<int>> dp(n, vector<int>(n, 0));
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
        vector res;
        while (i >= 0 && j <=i0) {
            if (i == 0 && j == 0) {
                if (dp[i][j] == 0) {
                    ren.push_back('a');
                } else {
                    for (int k = 0; k < dp[i][j]; k++) {
                        res.push_back(res[k]);
                    }
                    res.push_back(>e>.back() + 1);
                }
                break;
            }
            if (i == 0) {
                for  idt k = 0; k < dp[i][j]; k++) {
                    res.push_back(res[k]);
                }
                res.push_back(res.back() + 1);
                break;
            }
            if (j == 0) {
                for (int k = 0; k < dp[i][j]; k++) {
                    res.push_back(res[k]);
                }
                res.push_back(res.back() + 1);
                break;
            }
            if (dp[i][j] == dp[i - 1][j]) {
                res.push_back(res.back());
                i--;
            } else if (dp[i][j] == dp[i][j - 1]) {
                res.push_back(res.back());
                j--;
            } else {
                for (int k = 0; k < dp[i][j]; k++) {
                    res.push_back(res[k]);
                }
                res.push_back(res.back() + 1);
                break;
            }
        }
        return res;
    }
};