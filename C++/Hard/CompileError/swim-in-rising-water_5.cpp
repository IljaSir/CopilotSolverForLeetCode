class Solution {
public:
    int swimInWater(vector<vector<int>>& grid) {
        
        int n = grid.size();
        int left = grid[0][0], right = n*n-1;
        while (left < right) {
            int mid = left + (right-left)/2;
            if (canReach(grid, mid)) {
                right = mid;
            } else {
                left = mid+1;
            }
        }
        return left;
    }
};