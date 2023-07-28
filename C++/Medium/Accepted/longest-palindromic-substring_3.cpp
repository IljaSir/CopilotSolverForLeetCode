class Solution {
public:
    string longestPalindrome(string s) {
        
        int n = s.length();
        vector<vector<bool>> dp(n, vector<bool>(n, false));
        string ans = "";
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                dp[i][j] = (s[i] == s[j]) && ((j - i < 3) || dp[i + 1][j - 1]);
                if (dp[i][j] && ans.length() < j - i + 1) {
                    ans = s.substr(i, j - i + 1);
                }
            }
        }
        return ans;
    }
};