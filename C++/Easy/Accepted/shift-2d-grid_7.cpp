class Solution {
public:
    vector<vector<int>> shiftGrid(vector<vector<int>>& grid, int k) {
        
        int m = grid.size();
        int n = grid[0].size();
        int total = m * n;
        k = k % total;
        vector<int> temp;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                temp.push_back(grid[i][j]);
            }
        }
        for (int i = 0; i < k; i++) {
            temp.insert(temp.begin(), temp[total-1]);
            temp.pop_back();
        }
        vector<vector<int>> res(m, vector<int>(n));
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res[i][j] = temp[i*n+j];
            }
        }
        return res;
    }
};