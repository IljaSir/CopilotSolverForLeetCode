class Solution {
public:
    vector<int> getBiggestThree(vector<vector<int>>& grid) {
        
        int m = grid.size();
        int n = grid[0].size();
        vector<int> res;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int sum = grid[i][j];
                int x = i, y = j;
                int d = 1;
                while (x - d >= 0 && y - d >= 0 && x + d < m && y + d < n) {
                    sum += grid[x - d][y] + grid[x + d][y] + grid[x][y - d] + grid[x][y + d];
                    res.push_back(sum);
                    d++;
                }
            }
        }
        sort(res.begin(), res.end(), greater<int>());
        res.erase(unique(res.begin(), res.end()), res.end());
        while (res.size() > 3) {
            res.pop_back();
        }
        return res;
    }
};