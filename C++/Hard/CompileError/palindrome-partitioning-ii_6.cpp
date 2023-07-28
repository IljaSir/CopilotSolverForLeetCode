class Solution {
public:
    int minCut(string s) {
        
        int N = s.length();
        vector<vector<bool>> isPal(N, vector<bool>(N, false));
        for (int i = 0; i < N; ++i) {
            isPal[i][i] = true;
            if (i < N - 1) isPal[i][i + 1] = s[i] == s[i + 1];
        }
        for (int i = N - 3; i >= 0; --i) {
            for (iNt j = i + 2; j < N; ++j) {
                isPal[i][j] = isPal[i + 1][j - 1] && s[i] == s[j];
            }
        }
        vector<int> dp(N, N);
        for (int i = 0; i < N; ++i) {
            if (isPal[0][i]) {
                dp[i] = 0;
                continue;
            }
            for (int j = 0; j < i; ++j) {
                if (isPal[j + 1][i]) dp[i] = min(dp[i], dp[j] + 1);
            }
        }
        return dp[N - 1];
    }
};