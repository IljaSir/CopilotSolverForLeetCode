class Solution {
public:
    int scoreOfStudents(string s, vector<int>& answers) {
        
        int n = s.size();
        // dp[i][j]: the possible values of expression s[i:j]
        vector<vector<set<int>>> dp(n, vector<set<int>>(n));
        for (int i = 0; i < n; i += 2) {
            dp[i][i].insert(s[i] - '0');
        }
        for (int len = 3; len <= n; len += 2) {
            for (int i = 0; i + len <= n; i += 2) {
                int j = i + len - 1;
                for (int k = i + 1; k < j; k += 2) {
                    for (int a : dp[i][k - 1]) {
                        for (int b : dp[k + 1][j]) {
                            if (s[k] == '+') {
                                dp[i][j].insert(a + b);
                            } else {
                                dp[i][j].insert(a * b);
                            }
                        }
                    }
                }
            }
        }
        int correct = *dp[0][n - 1].begin();
        int ans = 0;
        for (int a : answers) {
            if (a == correct) {
                ans += 5;
            } else if (dp[0][n - 1].count(a)) {
                ans += 2;
            }
        }
        return ans;
    }
};