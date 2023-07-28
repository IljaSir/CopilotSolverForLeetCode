class Solution {
public:
    int countCombinations(vector<string>& pieces, vector<vector<int>>& positions) {
        
        int n = pieces.size();
        int res = 0;
        vector<vector<int>> dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}, {-1, -1}, {1, 1}, {1, -1}, {-1, 1}};
        vector<vector<int>> used(8, vector<int>(8, 0));
        for (int i = 0; i < n; ++i) {
            used[positions[i][0] - 1][positions[i][1] - 1] = 1;
        }
        vector<vector<int>> dp(8, vector<int>(8, 0));
        for (int i = 0; i < n; ++i) {
            if (pieces[i] == "rook") {
                for (int j = 0; j < 4; ++j) {
                    int x = positions[i][0] - 1, y = positions[i][1] - 1;
                    while (x >= 0 && x < 8 && y >= 0 && y < 8) {
                        dp[x][y] = 1;
                        x += dirs[j][0];
                        y += dirs[j][1];
                    }
                }
            } else if (pieces[i] == "bishop") {
                for (int j = 4; j < 8; ++j) {
                    int x = positions[i][0] - 1, y = positions[i][1] - 1;
                    while (x >= 0 && x < 8 && y >= 0 && y < 8) {
                        dp[x][y] = 1;
                        x += dirs[j][0];
                        y += dirs[j][1];
                    }
                }
            } else {
                for (int j = 0; j < 8; ++j) {
                    int x = positions[i][0] - 1, y = positions[i][1] - 1;
                    while (x >= 0 && x < 8 && y >= 0 && y < 8) {
                        dp[x][y] = 1;
                        x += dirs[j][0];
                        y += dirs[j][1];
                    }
                }
            }
        }
        for (int i = 0; i < 8;
    }
};