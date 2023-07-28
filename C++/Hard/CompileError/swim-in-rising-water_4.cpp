class Solution {
public:
    int swimInWater(vector<vector<int>>& grid) {
        
        int n = grid.size();
        int lo = 0;
        int hi = n * n;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (dfs(grid, 0, 0, mid)) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }
};