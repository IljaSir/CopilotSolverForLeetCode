class Solution {
public:
    double champagneTower(int poured, int query_row, int query_glass) {
        
        double dp[101][101] = {0.0};
        dp[0][0] = poured;
        for (int i = 0; i < query_row + 1; ++i) {
            for (int j = 0; j <= i; ++j) {
                if (dp[i][j] > 1.0) {
                    double left = (dp[i][j] - 1) / 2.0;
                    double right = left;
                    dp[i + 1][j] += left;
                    dp[i + 1][j + 1] += right;
                }
            }
        }
        return min(dp[query_row][query_glass], 1.0);
    }
};