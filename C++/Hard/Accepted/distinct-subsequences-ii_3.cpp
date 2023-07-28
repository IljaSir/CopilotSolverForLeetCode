class Solution {
public:
    int distinctSubseqII(string s) {
        
        int n = s.size();
        vector<int> dp(n+1, 0);
        dp[0] = 1;
        unordered_map<char, int> m;
        for (int i = 1; i <= n; i++) {
            dp[i] = (dp[i-1] * 2) % 1000000007;
            if (m.find(s[i-1]) != m.end()) {
                dp[i] -= dp[m[s[i-1]]];
                dp[i] = (dp[i] + 1000000007) % 1000000007;
            }
            m[s[i-1]] = i-1;
        }
        return (dp[n] - 1 + 1000000007) % 1000000007;
    }
};