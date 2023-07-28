class Solution {
public:
    int scoreOfStudents(string s, vector<int>& answers) {
        
        int n = s.size();
        int result = 0;
        vector<vector<unordered_set<int>>> dp(n, vector<unordered_set<int>>(n));
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
                if (len == n) {
                    for (int a : dp[0][n - 1]) {
                        if (a == answers[0]) {
                            result += 5;
                        } else if (find(answers.begin() + 1, answers.end(), a) != answers.end()) {
                            result += 2;
                        }
                    }
                }
            }
        }
        return result;
    }
};