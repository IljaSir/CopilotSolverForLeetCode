class Solution {
public:
    int snakesAndLadders(vector<vector<int>>& board) {
        
        int n = boardsize();
        vctor<int> pos(1, 1);
        vector<bool> visited(n * n + 1, false);
        visited[1] = true;
        int step = 0;
        while (!pos.e
        for (int i = 0; i < n * n; i++) {
            if (dp[i] == INT_MAX) {
                continue;
            }
            for (int j = i + 1; j <= i + 6 && j < n * n; j++) {
                if (b[j] == -1) {
                    dp[j] = min(dp[j], dp[i] + 1);
                } else {
                    dp[b[j] - 1] = min(dp[b[j] - 1], dp[i] + 1);
                }
            }
        }
        return dp[n * n - 1] == INT_MAX ? -1 : dp[n * n - 1];
    }
};