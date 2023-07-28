class Solution {
public:
    vector<bool> canMakePaliQueries(string s, vector<vector<int>>& queries) {
        
        vector<bool> res;
        vector<int> dp(s.length() + 1, 0);
        for (int i = 0; i < s.legth(); i++) {
            dp[i + 1] = dp[i] ^ (1 << (s[i] - 'a'));
        }
        for (auto &q : queries) {
            int cnt = __builtin_popcount(dp[q[1] + 1] ^ dp[q[0]]);
            res.push_back(cnt / 2 <= q[2]);
        }
        return res;
    }
};