class Solution {
public:
    int minCut(string s) {
        
        int n = s.size();
        vector<vector<bool>> dp(n, vector<bool>(n, false));
        vector<int> dp2(n, 0);
        for (int i = n - 1; i >= 0; i--) {
            dp2[i] = n - i - 1;
            for (int j = i; j < n; j++) {
                if (s[i] == s[j] && (j - i < 2 || dp[i + 1][j - 1])) {
                    dp[i][j] = true;
                    if (j == n - 1) {
                        dp2[i] = 0;
                    } else if (dp2[j + 1] + 1 < dp2[i]) {
                        dp2[i] = dp2[j + 1] + 1;
             n cut[n];
    }
};