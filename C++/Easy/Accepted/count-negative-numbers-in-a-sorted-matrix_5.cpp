class Solution {
public:
    int countNegatives(vector<vector<int>>& grid) {
        
        int ans = 0;
        for (int i = 0; i < grid.size(); i++) {
            int left = 0, right = grid[i].size() - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (grid[i][mid] >= 0) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            ans += grid[i].size() - left;
        }
        return ans;
    }
};