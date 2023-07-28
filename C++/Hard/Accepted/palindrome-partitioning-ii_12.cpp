class Solution {
public:
    int minCut(string s) {
        
        int n = s.length();
        vector<vector<bool>> dp(n, vector<bool>(n, false));
        vector<int> minCut(n, 0);
        for (int i = 0; i < n; i++) {
            minCut[i] = i;
            for (int j = 0; j <= i; j++) {
                if (s[i] == s[j] && (i - j < 2 || dp[j + 1][i - 1])) {
                    dp[j][i] = true;
                    if (j > 0) {
                        minCut[i] = min(minCut[i], minCut[j - 1] + 1);
                    } else {
                        minCut[i] = 0;
                    }
                }
            }
        }
        return minCut[n - 1];
    }
};