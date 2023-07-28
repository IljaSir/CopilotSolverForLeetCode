class Solution {
public:
    int countVowelStrings(int n) {
        
        const int N = 5;
        vector<int> dp(N, 1);
        for (int i = 1; i < n; ++i) {
            for (int j = N - 2; j >= 0; --j) {
                dp[j] += dp[j + 1];
            }
        }
        return accumulate(dp.begin(), dp.end(), 0);
    }
};