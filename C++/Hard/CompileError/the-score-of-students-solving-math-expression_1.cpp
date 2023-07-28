class Solution {
public:
    int scoreOfStudents(string s, vector<int>& answers) {
        
        int n = s.size();
        vector<vector<int>> dp(n + 1, vector<int>(n + 1, 0));
        for (int i = 0; i < n; i += 2) {
            dp[i][i] = s[i] - '0';
        }
        for (int len = 2; len <= n; len += 2) {
            for (int i = 0; i + len <= n; i += 2) {
                int j = i + len;
                for (int k = i + 1; k < j; k += 2) {
                    if (s[k] == '+') {
                        for (int x : dp[i][k - 1]) {
                            for (int y : dp[k + 1][j]) {
                                dp[i][j].push_back(x + y);
                            }
                        }
                    } else {
                        for (int x : dp[i][k - 1]) {
                            for (int y : dp[k + 1][j]) {
                                dp[i][j].push_back(x * y);
                            }
                        }
                    }
                }
                if (len == n) {
                    for (int x : dp[i][j]) {
                        dp[i][j].push_back(x);
                    }
                }
            }
        }
        int ans = 0;
        for (int x : answers) {
            if (find(dp[0][n].begin(), dp[0][n].end(), x) != dp[0][n].end()) {
                ans += 5;
            } else if (x == dp[0][n][0]) {
                ans += 2;
            }
        }
        return ans;
    }
};