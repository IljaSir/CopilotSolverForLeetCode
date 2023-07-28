class Solution {
public:
    bool wordBreak(string s, vector<string>& wordDict) {
        
        int n = s.size();
        vector<bool> dp(n+1, false);
        dp[0] = true;
        for(int i = 1; i <= n; i++) {
            for(string word : wordDict) {
                int l = word.size();
                if(i >= l && s.substr(i-l, l) == word) {
                    dp[i] |= dp[i-l];
                }
            }
        }
        return dp[n];
    }
};