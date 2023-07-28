class Solution {
public:
    int beautifulPartitions(string s, int k, int minLength) {
        
        int n = s.size();
        vector<vector<int>> dp(n + 1, vector<int>(k + 1));
        dp[0][0] = 1;
        for (int i = minLength; i <= n; ++i) {
            for (int j = 1; j <= k; ++j) {
                for (int l = i - 1; l >= j - 1; --l) {
                    if (isBeautiful(s, l, i)) {
                        dp[i][j] += dp[l][j - 1];
                        dp[i][j] %= 1000000007;
                    }
                }
            }
        }
        return dp[n][k];
    }
    
    bool isBeautiful(string &s, int start, int end) {
        if (end - start < 2) return false;
        if (s[start] != '2' && s[start] != '3' && s[start] != '5' && s[start] != '7') return false;
        if (s[end - 1] == '2' || s[end - 1] == '3' || s[end - 1] == '5' || s[end - 1] == '7') return false;
        return true;
    }
};