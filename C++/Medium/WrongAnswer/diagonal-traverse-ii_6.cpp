class Solution {
public:
    vector<int> findDiagonalOrder(vector<vector<int>>& nums) {
        
        int m = nums.size();
        int n = 0;
        for (auto& row : nums) {
            n = max(n, (int)row.size());
        }
        vector<vector<int>> grid(m, vector<int>(n, 0));
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < nums[i].size(); ++j) {
                grid[i][j] = nums[i][j];
            }
        }
        vector<int> res;
        int i = 0;
        int j = 0;
        int d = 1;
        while (i < m && j < n) {
            res.push_back(grid[i][j]);
            int ni = i + d;
            int nj = j - d;
            if (ni < 0 || ni >= m) {
                ni = i;
                nj = j + 1;
                d = -d;
            }
            if (nj < 0 || nj >= n) {
                ni = i + 1;
                nj = j;
                d = -d;
            }
            i = ni;
            j = nj;
        }
        return res;
    }
};