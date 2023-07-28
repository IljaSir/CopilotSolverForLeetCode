class Solution {
public:
    int scoreOfStudents(string s, vector<int>& answers) {
        
        int ans = 0;
        int n = s.size();
        vector<vector<int>> dp(n, vector<int>(n, 0));
        for (int i = 0; i < n; i += 2) {
            dp[i][i] = s[i] - '0';
        }
        for (int i = 1; i < n; i += 2) {
            for (int j = 0; j + i < n; j += 2) {
                int k = j + i;
                if (s[k] == '+') {
                    for (int l = j; l < k; l += 2) {
                        dp[j][k] = max(dp[j][k], dp[j][l] + dp[l + 2][k]);
                    }
                } else {
                    for (int l = j; l < k; l += 2) {
                        dp[j][k] = max(dp[j][k], dp[j][l] * dp[l + 2][k]);
                    }
                }
                for (int l = j; l < k; l += 2) {
                    if (s[l + 1] == '+') {
                        dp[j][k] = max(dp[j][k], dp[j][l] + dp[l + 2][k] + dp[l + 1][l + 1]);
                    } else {
                        dp[j][k] = max(dp[j][k], dp[j][l] * dp[l + 2][k] + dp[l + 1][l + 1]);
                    }
                }
            }
        }
        int correct = dp[0][n - 1];
        for (int answer : answers) {
            if (answer == correct) {
                ans += 5;
            } else if (find(begin(dp[0]), end(dp[0]), answer) != end(dp[0])) {
                ans += 2;
            }
        }
        return ans;
    }
};