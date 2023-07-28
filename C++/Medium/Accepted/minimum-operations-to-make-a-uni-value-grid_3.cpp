class Solution {
public:
    int minOperations(vector<vector<int>>& grid, int x) {
        
        int m = grid.size(), n = grid[0].size();
        vector<int> nums;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                nums.push_back(grid[i][j]);
            }
        }
        sort(nums.begin(), nums.end());
        int mid = nums[nums.size() / 2], ans = 0;
        for (int i = 0; i < nums.size(); ++i) {
            int diff = abs(nums[i] - mid);
            if (diff % x != 0) {
                return -1;
            }
            ans += diff / x;
        }
        return ans;
    }
};