class Solution {
public:
    int minCut(string s) {
        
        int n = s.size();
        vector<vector<bool>> dp(n, vector<bool>(n, false));
        vector<int> cut(n, 0);
        for (int i = 0; i < n; i++) {
            cut[i] = i;
            for (int j = 0; j <= i; j++) {
                if (s[i] == s[j] && (i - j < 2 || dp[j + 1][i - 1])) {
                    dp[j][i] = true;
                    if (j > 0) {
                        cut[i] = min(cut[i], cut[j - 1] + 1);
                    } else {
                        cut[i] = 0;
                    }
                }
            }
        }
        return cut[n - 1];
    }
};