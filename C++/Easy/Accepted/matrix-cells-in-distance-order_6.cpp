class Solution {
public:
    vector<vector<int>> allCellsDistOrder(int rows, int cols, int rCenter, int cCenter) {
        
        vector<vector<int>> res;
        vector<vector<int>> dist(rows, vector<int>(cols, 0));
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < cols; ++j) {
                dist[i][j] = abs(i - rCenter) + abs(j - cCenter);
            }
        }
        vector<pair<int, pair<int, int>>> v;
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < cols; ++j) {
                v.push_back({dist[i][j], {i, j}});
            }
        }
        sort(v.begin(), v.end());
        for (auto& p : v) {
            res.push_back({p.second.first, p.second.second});
        }
        return res;
    }
};