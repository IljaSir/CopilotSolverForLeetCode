class Solution {
public:
    int minOperations(vector<vector<int>>& grid, int x) {
        
        int m = grid.size();
        int n = grid[0].size();
        vector<int> res;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                res.push_back(grid[i][j]);
            }
        }
        sort(res.begin(), res.end());
        int mid = res[res.size() / 2];
        int ans = 0;
        for (int i = 0; i < res.size(); ++i) {
            int d = abs(res[i] - mid);
            if (d % x != 0) {
                return -1;
            }
            ans += d / x;
        }
        return ans;
    }
};