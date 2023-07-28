class Solution {
public:
    int atMostNGivenDigitSet(vector<string>& digits, int n) {
        
        string s = to_string(n);
        int m = s.size();
        int k = digits.size();
        vector<int> dp(m+1);
        dp[m] = 1;
        for (int i = m-1; i >= 0; --i) {
            int si = s[i] - '0';
            for (string &d: digits) {
                if (stoi(d) < si) {
                    dp[i] += pow(k, m-i-1);
                } else if (stoi(d) == si) {
                    dp[i] += dp[i+1];
                }
            }
        }
        for (int i = 1; i < m; ++i) {
            dp[0] += pow(k, i);
        }
        return dp[0];
    }
};