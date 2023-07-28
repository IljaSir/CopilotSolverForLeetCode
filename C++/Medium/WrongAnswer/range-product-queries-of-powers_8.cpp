class Solution {
public:
    vector<int> productQueries(int n, vector<vector<int>>& queries) {
        
        vector<int> powers;
        while (n) {
            powers.push_back(n & 1);
            n >>= 1;
        }
        int m = powers.size();
        vector<vector<int>> dp(m, vector<int>(m, 0));
        for (int i = 0; i < m; i++) {
            dp[i][i] = powers[i];
        }
        for (int i = 0; i < m; i++) {
            for (int j = i + 1; j < m; j++) {
                dp[i][j] = dp[i][j - 1] * dp[j][j];
            }
        }
        vector<int> res;
        for (auto& q: queries) {
            res.push_back(dp[q[0]][q[1]]);
        }
        return res;
    }
};