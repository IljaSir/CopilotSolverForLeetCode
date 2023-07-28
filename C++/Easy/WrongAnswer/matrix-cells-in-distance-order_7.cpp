class Solution {
public:
    vector<vector<int>> allCellsDistOrder(int rows, int cols, int rCenter, int cCenter) {
        
        vector<vector<int>> ans;
        ans.push_back({rCenter, cCenter});
        for (int i = 1; i < max(rows, cols); ++i) {
            for (int j = 0; j < i; ++j) {
                int x = rCenter - i + j;
                int y = cCenter + j;
                if (x >= 0 && x < rows && y >= 0 && y < cols) {
                    ans.push_back({x, y});
                }
                x = rCenter + i - j;
                y = cCenter - j;
                if (x >= 0 && x < rows && y >= 0 && y < cols) {
                    ans.push_back({x, y});
                }
                x = rCenter + j;
                y = cCenter + i - j;
                if (x >= 0 && x < rows && y >= 0 && y < cols) {
                    ans.push_back({x, y});
                }
                x = rCenter - j;
                y = cCenter - i + j;
                if (x >= 0 && x < rows && y >= 0 && y < cols) {
                    ans.push_back({x, y});
                }
            }
        }
        return ans;
    }
};