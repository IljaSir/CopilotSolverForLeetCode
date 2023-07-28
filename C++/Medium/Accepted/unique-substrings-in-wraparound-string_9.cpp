class Solution {
public:
    int findSubstringInWraproundString(string s) {
        
        int n = s.length();
        if (n < 2) return n;
        int dp[26] = {0};
        int cnt = 1;
        dp[s[0]-'a'] = 1;
        for (int i = 1; i < n; i++) {
            if (s[i] == (s[i-1]+1) || (s[i] == 'a' && s[i-1] == 'z')) {
                cnt++;
            } else {
                cnt = 1;
            }
            dp[s[i]-'a'] = max(dp[s[i]-'a'], cnt);
        }
        int ans = 0;
        for (int i = 0; i < 26; i++) {
            ans += dp[i];
        }
        return ans;
    }
};