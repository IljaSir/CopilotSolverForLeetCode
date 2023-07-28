class Solution {
public:
    int numberOfArrays(vector<int>& differences, int lower, int upper) {
        
        int n = differences.size();
        int64_t mod = 1e9 + 7;
        vector<int64_t> dp(n + 1);
        dp[0] = 1;
        for (int i = 0; i < n; ++i) {
            if (differences[i] > 0) {
                dp[i + 1] = (dp[i] * (upper - lower + 1) + mod) % mod;
            } else if (differences[i] == 0) {
                dp[i + 1] = dp[i];
            } else {
                dp[i + 1] = (dp[i] * (lower - upper + 1) + mod) % mod;
            }
            if (differences[i] > 0) {
                lower -= differences[i];
                upper -= differences[i];
            } else if (differences[i] < 0) {
                lower -= differences[i];
                upper -= differences[i];
            }
            lower = max(lower, 1);
            upper = min(upper, 100000);
            if (lower > upper) {
                return 0;
            }
        }
        return dp[n];
    }
};