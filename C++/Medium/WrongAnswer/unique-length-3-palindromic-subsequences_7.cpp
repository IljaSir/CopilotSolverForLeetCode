class Solution {
public:
    int countPalindromicSubsequence(string s) {
        
        int N = s.size();
        vector<vector<int>> dp(N, vector<int>(N, 0));
        unordered_map<char, int> pos;
        for (int i = 0; i < N; i++) {
            if (pos.count(s[i])) {
                dp[pos[s[i]]][i] = 1;
            }
            pos[s[i]] = i;
        }
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                dp[i][j] += dp[i][j - 1];
            }
        }
        int res = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i + 2; j < N; j++) {
                if (s[i] == s[j]) {
                    res += dp[i + 1][j - 1];
                }
            }
        }
        return res;
    }
};