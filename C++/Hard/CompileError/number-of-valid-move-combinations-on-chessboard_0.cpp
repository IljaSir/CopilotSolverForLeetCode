class Solution {
public:
    int countCombinations(vector<string>& pieces, vector<vector<int>>& positions) {
        
        int n = pieces.size();
        vector<int> x(n), y(n);
        for (int i = 0; i < n; ++i) {
            x[i] = positions[i][0];
            y[i] = positions[i][1];
        }
        int ans = 0;
        vector<int> dx = {-1, 1, 0, 0, -1, -1, 1, 1};
        vector<int> dy = {0, 0, -1, 1, -1, 1, -1, 1};
        for (int i = 0; i < (1 << n); ++i) {
            vector<vector<int>> f(9, vector<int>(9, 0));
            for (int j = 0; j < n; ++j) {
                if (i >> j & 1) {
                    f[x[j]][y[j]] = 1;
                    if (pieces[j] == "rook") {
                        for (int k = 0; k < 4; ++k) {
                            int tx = x[j] + dx[k];
                            int ty = y[j] + dy[k];
                            while (tx >= 1 && tx <= 8 && ty >= 1 && ty <= 8) {
                                f[tx][ty] = 1;
                                tx += dx[k];
                                ty += dy[k];
                            }
                        }
                    } else if (pieces[j] == "queen") {
                        for (int k = 0; k < 8; ++k) {
                            int tx = x[j] + dx[k];
                            int ty = y[j] + dy[k];
                            while (tx >= 1 && tx <= 8 && ty >= 1 && ty <= 8) {
                                f[tx][ty] = 1;
                                tx += dx[k];
                                ty += dy[k];
                            }
                        }
                    } else {
                        for (int k = 0; k < 4; ++k) {
                            int tx = x[j] + dx[k + 4];
                            int ty = y[j] + dy[k + 4];
                            if (tx >= 1 && tx <= 8 && ty >= 1 && ty <= 8) {
                                f[tx][ty] = 1;
                            }
                        }
                    }
    }
};