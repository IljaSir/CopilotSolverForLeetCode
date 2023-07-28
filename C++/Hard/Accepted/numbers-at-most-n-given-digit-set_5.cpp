class Solution {
public:
    int atMostNGivenDigitSet(vector<string>& digits, int n) {
        
        string s = to_string(n);
        int m = s.size();
        int k = digits.size();
        vector<int> dp(m + 1, 0);
        dp[m] = 1;
        for (int i = m - 1; i >= 0; --i) {
            int si = s[i] - '0';
            for (int j = 0; j < k; ++j) {
                int dj = digits[j][0] - '0';
                if (dj < si) {
                    dp[i] += pow(k, m - i - 1);
                } else if (dj == si) {
                    dp[i] += dp[i + 1];
                }
            }
        }
        for (int i = 1; i < m; ++i) {
            dp[0] += pow(k, i);
        }
        return dp[0];
    }
};