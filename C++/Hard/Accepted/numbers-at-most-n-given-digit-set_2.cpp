class Solution {
public:
    int atMostNGivenDigitSet(vector<string>& digits, int n) {
        
        string s = to_string(n);
        int k = s.size();
        vector<int> dp(k+1);
        dp[k] = 1;
        for (int i = k-1; i >= 0; i--) {
            int si = s[i] - '0';
            for (string& d : digits) {
                if (stoi(d) < si) dp[i] += pow(digits.size(), k-i-1);
                else if (stoi(d) == si) dp[i] += dp[i+1];
            }
        }
        for (int i = 1; i < k; i++) dp[0] += pow(digits.size(), i);
        return dp[0];
    }
};