class Solution {
public:
    vector<bool> canMakePaliQueries(string s, vector<vector<int>>& queries) {
        
        vector<bool> ans;
        int n = s.size();
        vector<vector<int>> dp(n + 1, vector<int>(26, 0));
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < 26; ++j) {
                dp[i + 1][j] = dp[i][j];
            }
            dp[i + 1][s[i] - 'a']++;
        }
        for (auto &q : queries) {
            int odd = 0;
            for (int i = 0; i < 26; ++i) {
                odd += (dp[q[1] + 1][i] - dp[q[0]][i]) % 2;
            }
            ans.push_back(odd / 2 <= q[2]);
        }
        return ans;
    }
};