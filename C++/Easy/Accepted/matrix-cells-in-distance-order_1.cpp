class Solution {
public:
    vector<vector<int>> allCellsDistOrder(int rows, int cols, int rCenter, int cCenter) {
        
        vector<vector<int>> res;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                res.push_back({i, j});
            }
        }
        sort(res.begin(), res.end(), [rCenter, cCenter](vector<int> a, vector<int> b) {
            return abs(a[0] - rCenter) + abs(a[1] - cCenter) < abs(b[0] - rCenter) + abs(b[1] - cCenter);
        });
        return res;
    }
};