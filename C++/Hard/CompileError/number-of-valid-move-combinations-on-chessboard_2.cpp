class Solution {
public:
    int countCombinations(vector<string>& pieces, vector<vector<int>>& positions) {
        
        int n = pieces.size();
        vector<vector<int>> dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
        vector<int> x(n), y(n);
        for (int i = 0; i < n; ++i) {
            x[i] = positions[i][0];
            y[i] = positions[i][1];
        }
        int ans = 0;
        for (int i = 0; i < (1 << n); ++i) {
            vector<vector<int>> vis(9, vector<int>(9));
            for (int j = 0; j < n; ++j) {
                if ((i >> j) & 1) {
                    if (pieces[j] == "rook") {
                        for (int k = 0; k < 4; ++k) {
                            int nx = x[j] + dir[k][0], ny = y[j] + dir[k][1];
                            while (nx >= 1 && nx <= 8 && ny >= 1 && ny <= 8) {
                                ++vis[nx][ny];
                                nx += dir[k][0], ny += dir[k][1];
                            }
                        }
                    } else if (pieces[j] == "bishop") {
                        for (int k = 4; k < 8; ++k) {
                            int nx = x[j] + dir[k][0], ny = y[j] + dir[k][1];
                            while (nx >= 1 && nx <= 8 && ny >= 1 && ny <= 8) {
                                ++vis[nx][ny];
                                nx += dir[k][0], ny += dir[k][1];
                            }
                        }
                    } else {
                        for (int k = 0; k < 8; ++k) {
                            int nx = x[j] + dir[k][0], ny = y[j] + dir[k][1];
                            while (nx >= 1 && nx <= 8 && ny >= 1 && ny <= 8) {
                                ++vis[nx][ny];
                                nx += dir[k][0], ny += dir[k][1];
                            }
                        }
                    }
                }
            }
            int cnt =
    }
};