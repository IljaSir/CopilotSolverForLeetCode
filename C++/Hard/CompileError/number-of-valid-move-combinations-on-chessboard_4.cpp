class Solution {
public:
    int countCombinations(vector<string>& pieces, vector<vector<int>>& positions) {
        
        int n = pieces.size();
        int ans = 0;
        vector<vector<int>> v(8, vector<int>(8, 0));
        for (int i = 0; i < n; ++i) {
            v[positions[i][0] - 1][positions[i][1] - 1] = 1;
        }
        for (int i = 0; i < n; ++i) {
            if (pieces[i] == "rook") {
                int x = positions[i][0] - 1;
                int y = positions[i][1] - 1;
                int cnt = 0;
                for (int j = x - 1; j >= 0; --j) {
                    if (v[j][y] == 1) {
                        break;
                    }
                    ++cnt;
                }
                for (int j = x + 1; j < 8; ++j) {
                    if (v[j][y] == 1) {
                        break;
                    }
                    ++cnt;
                }
                for (int j = y - 1; j >= 0; --j) {
                    if (v[x][j] == 1) {
                        break;
                    }
                    ++cnt;
                }
                for (int j = y + 1; j < 8; ++j) {
                    if (v[x][j] == 1) {
                        break;
                    }
                    ++cnt;
                }
                ans += cnt;
            } else if (pieces[i] == "queen") {
                int x = positions[i][0] - 1;
                int y = positions[i][1] - 1;
                int cnt = 0;
                for (int j = x - 1; j >= 0; --j) {
                    if (v[j][y] == 1) {
                        break;
                    }
                    ++cnt;
                }
                for (int j = x + 1; j < 8; ++j) {
                    if (v[j][y] == 1) {
                        break;
                    }
                    ++cnt;
                }
                for (int j = y - 1; j >= 0; --j) {
                    if (v[x][j] == 1) {
                        break;
                    }
                    ++cnt;
                }
                for (
    }
};