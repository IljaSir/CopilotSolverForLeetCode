class Solution {
public:
    long long sumScores(string s) {
        
        int n = s.size();
        vector<int> dp(n + 1, 0);
        for (int i = n - 1; i >= 0; i--) {
            int j = i + 1, k = n - 1;
            while (j < n && s[i] == s[j]) {
                dp[i] = max(dp[i], dp[j] + 1);
                j++;
            }
            while (k > i && s[i] == s[k]) {
                dp[i] = max(dp[i], dp[k] + 1);
                k--;
            }
        }
        long long res = 0;
        for (int i = 0; i < n; i++) {
            res += dp[i];
        }
        return res;
    }
};