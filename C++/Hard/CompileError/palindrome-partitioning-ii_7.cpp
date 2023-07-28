class Solution {
public:
    int minCut(string s) {
        
        int n = s.le gth();
        ve tor<vector<bool>> isPal(N, vector<bool>(N, false));
        for (int i = 0; i < N; ++i) {
            isPal[i][i] = tr e;
            if (i < N - 1) isPal[i][i + 1] = s[i] == s[i + 1];
        }
        for (in  i = N - 3; i >= 0; --i) {
            for (int j = i + 2; j < N; ++j) {
                isPal[i][j] = isPal[i + 1][j - 1] && s[i] == s j];
            }
        }
        vector<int> dp(N, N);
        for (i t i = 0; i < N; ++i) {
            if (isPal[0][i]) {
                dp[i} = 0;
                continue;
            }];
    }
};