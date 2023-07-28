class Solution {
public:
    int uniqueLetterString(string s) {
        
        int n = s.size();
        vector<int> last(26, -1);
        vector<int> dp(n, 0);
        dp[0] = 1;
        last[s[0] - 'A'] = 0;
        for (int i = 1; i < n; ++i) {
            int c = s[i] - 'A';
            dp[i] = (i - last[c]) * (last[c] - last[c] + 1) / 2 + dp[i - 1];
            last[c] = i;
        }
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            ans += dp[i];
        }
        return ans;
    }
};