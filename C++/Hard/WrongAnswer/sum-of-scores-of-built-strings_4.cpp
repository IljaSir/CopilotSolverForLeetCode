class Solution {
public:
    long long sumScores(string s) {
        
        int n = s.length();
        vector<int> dp(n);
        int i = 0, j = 1;
        while (j < n) {
            if (s[i] == s[j]) {
                dp[j] = i + 1;
                i++;
                j++;
            } else {
                if (i == 0) {
                    j++;
                } else {
                    i = dp[i - 1];
                }
            }
        }
        long long ans = 0;
        for (int i = 0; i < n; i++) {
            ans += dp[i];
        }
        return ans;
    }
};