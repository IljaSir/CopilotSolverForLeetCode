class Solution {
public:
    int scoreOfStudents(string s, vector<int>& answers) {
        
        int n = s.size();
        vector<unordered_set<int>> dp(n + 1, unordered_set<int>());
        dp[0].insert(0);
        for (int i = 0; i < n; i++) {
            if (s[i] == '*') {
                for (int j = 0; j <= i; j++) {
                    for (auto a : dp[j]) {
                        for (auto b : dp[i - j]) {
                            dp[i + 1].insert(a * b);
                        }
                    }
                }
            } else {
                for (auto a : dp[i]) {
                    dp[i + 1].insert(a + s[i] - '0');
                }
            }
        }
        int ans = 0;
        for (auto a : answers) {
            if (dp[n].count(a)) {
                ans += 5;
            } else {
                for (int i = 0; i < n; i++) {
                    if (s[i] == '*') {
                        for (auto b : dp[n - i - 1]) {
                            if (dp[i].count(a - b)) {
                                ans += 2;
                                break;
                            }
                        }
                    }
                }
            }
        }
        return ans;
    }
};