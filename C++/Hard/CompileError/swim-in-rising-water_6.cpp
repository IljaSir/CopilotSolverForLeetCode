class Solution {
public:
    int swimInWater(vector<vector<int>>& grid) {
        
        int n = grid.size();
        int low = grid[0][0], high = n*n-1;
        while (low < high) {
            int mid = low + (high-low)/2;
            if (canReach(grid, mid)) high = mid;
            else low = mid+1;
        }
        return low;
    }
};