class Solution {
public:
    int minOperations(vector<vector<int>>& grid, int x) {
        
        int n = grid.size();
        int m = grid[0].size();
        int cnt = n * m;
        vector<int> nums;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                nums.push_back(grid[i][j]);
            }
        }
        sort(nums.begin(), nums.end());
        int mid = nums[cnt / 2];
        int ans = 0;
        for (int i = 0; i < cnt; i++) {
            if (abs(nums[i] - mid) % x != 0) {
                return -1;
            }
            ans += abs(nums[i] - mid) / x;
        }
        return ans;
    }
};