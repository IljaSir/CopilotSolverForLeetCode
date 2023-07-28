class Solution {
public:
    int minOperations(vector<vector<int>>& grid, int x) {
        
        int m = grid.size(), n = grid[0].size();
        vector<int> v;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                v.push_back(grid[i][j]);
            }
        }
        sort(v.begin(), v.end());
        int ans = 0, mid = v[(m * n) / 2];
        for (int i = 0; i < m * n; i++) {
            int diff = abs(v[i] - mid);
            if (diff % x != 0) return -1;
            ans += diff / x;
        }
        return ans;
    }
};