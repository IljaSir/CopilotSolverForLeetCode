class Solution {
public:
    int countVowelStrings(int n) {
        
        int dp[5] = {1, 1, 1, 1, 1};
        for (int i = 2; i <= n; ++i) {
            for (int j = 3; j >= 0; --j) {
                dp[j] += dp[j + 1];
            }
        }
        return accumulate(dp, dp + 5, 0);
    }
};