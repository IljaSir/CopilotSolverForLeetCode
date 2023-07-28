class Solution {
public:
    string longestPrefix(string s) {
        
        int n = s.size();
        vector<int> dp(n, 0);
        for (int i = 1; i < n; i++) {
            int j = dp[i - 1];
            while (j > 0 && s[i] != s[j])
                j = dp[j - 1];
            if (s[i] == s[j])
                j++;
            dp[i] = j;
        }
        return s.substr(0, dp[n - 1]);
    }
};