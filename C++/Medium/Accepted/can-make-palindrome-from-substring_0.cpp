class Solution {
public:
    vector<bool> canMakePaliQueries(string s, vector<vector<int>>& queries) {
        
        int n = s.size();
        vector<vector<int>> dp(n + 1, vector<int>(26, 0));
        for (int i = 0; i < n; ++i) {
            dp[i + 1] = dp[i];
            ++dp[i + 1][s[i] - 'a'];
        }
        vector<bool> ans;
        for (auto &q : queries) {
            int oddCnt = 0;
            for (int i = 0; i < 26; ++i) {
                oddCnt += (dp[q[1] + 1][i] - dp[q[0]][i]) & 1;
            }
            ans.push_back(oddCnt / 2 <= q[2]);
        }
        return ans;
    }
};