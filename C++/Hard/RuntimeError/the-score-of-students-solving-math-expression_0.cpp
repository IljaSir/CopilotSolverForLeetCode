class Solution {
public:
    int scoreOfStudents(string s, vector<int>& answers) {
        
        int n = s.size();
        vector<vector<int>> dp(n, vector<int>(n, 0));
        for (int i = 0; i < n; i += 2) {
            dp[i][i] = s[i] - '0';
        }
        for (int i = 3; i <= n; i += 2) {
            for (int j = 0; j + i <= n; j += 2) {
                dp[j][j + i - 1] = INT_MAX;
                for (int k = j + 1; k < j + i - 1; k += 2) {
                    int a = dp[j][k - 1];
                    int b = dp[k + 1][j + i - 1];
                    if (s[k] == '+') {
                        dp[j][j + i - 1] = min(dp[j][j + i - 1], a + b);
                    }
                    else {
                        dp[j][j + i - 1] = min(dp[j][j + i - 1], a * b);
                    }
                }
                if (i == n) {
                    continue;
                }
                for (int k = j; k < j + i; k += 2) {
                    int a = dp[j][k];
                    int b = dp[k + 1][j + i - 1];
                    if (s[k + 1] == '+') {
                        dp[j][j + i - 1] = min(dp[j][j + i - 1], a + b);
                    }
                    else {
                        dp[j][j + i - 1] = min(dp[j][j + i - 1], a * b);
                    }
                }
            }
        }
        int ans = 0;
        for (auto& x : answers) {
            if (x == dp[0][n - 1]) {
                ans += 5;
            }
            else {
                bool flag = false;
                for (int i = 0; i < n; i += 2) {
                    if (x == dp[0][i]) {
                        flag = true;
                        break;
                    }
                }
                if (flag) {
                    ans += 2;
                }
            }
        }
        return ans;
    }
};