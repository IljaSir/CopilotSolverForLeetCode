class Solution {
public:
    long long maxProduct(string s) {
        
        int n = s.length();
        vector<vector<int>> dp(n, vector<int>(n, 0));
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }
        for (int i = 0; i < n - 1; i++) {
            if (s[i] == s[i + 1]) {
                dp[i][i + 1] = 1;
            }
        }
        for (int i = 2; i < n; i++) {
            for (int j = 0; j + i < n; j++) {
                if (s[j] == s[j + i] && dp[j + 1][j + i - 1] == 1) {
                    dp[j][j + i] = 1;
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int l = 0, r = n - 1;
            while (l < i && r > i) {
                if (dp[l][i - 1] == 1 && dp[i + 1][r] == 1) {
                    ans = max(ans, (i - l) * (r - i));
                    break;
                }
                if (dp[l][i - 1] == 0) {
                    l++;
                } else {
                    r--;
                }
            }
        }
        return ans;
    }
};