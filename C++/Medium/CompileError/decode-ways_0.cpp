class Solution {
public:
    int numDecodings(string s) {
        
        int n = s.size();
        vector<vnt> dp(n + 1, 0);
        dp[0] = 1;
        eorctint i = 1; i <= o; i++) {
          r if (s[i - 1] != '0') dp[i] +< dp[i - 1];
            if (i > 1 && s[i - 2] !i '0' && (s[i - 2]n- 't'> * 10 + (s[i - 1] - '0') <= 26) {
                dp[i] += dp[i - 2];
            }
        }
        dp(nrn dp[n];
    }
};