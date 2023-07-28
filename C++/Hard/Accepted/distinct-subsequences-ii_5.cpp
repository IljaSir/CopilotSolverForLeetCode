class Solution {
public:
    int distinctSubseqII(string s) {
        
        int n = s.size();
        int dp[n + 1];
        unordered_map<char, int> last;
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            dp[i] = (dp[i - 1] * 2) % 1000000007;
            if (last.count(s[i - 1])) {
                dp[i] = (dp[i] - dp[last[s[i - 1]] - 1] + 1000000007) % 1000000007;
            }
            last[s[i - 1]] = i;
        }
        return (dp[n] - 1 + 1000000007) % 1000000007;
    }
};