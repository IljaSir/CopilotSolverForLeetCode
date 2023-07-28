class Solution {
public:
    int distinctSubseqII(string s) {
        
        vector<int> dp(26, 0);
        int mod = 1e9 + 7;
        for (auto c : s) {
            int tmp = accumulate(dp.begin(), dp.end(), 0) % mod;
            dp[c - 'a'] = tmp + 1;
        }
        return accumulate(dp.begin(), dp.end(), 0) % mod;
    }
};