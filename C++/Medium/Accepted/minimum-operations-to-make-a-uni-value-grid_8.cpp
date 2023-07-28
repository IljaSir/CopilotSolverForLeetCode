class Solution {
public:
    int minOperations(vector<vector<int>>& grid, int x) {
        
        int m = grid.size();
        int n = grid[0].size();
        int cnt = 0;
        vector<int> nums(m*n);
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                nums[cnt++] = grid[i][j];
            }
        }
        sort(nums.begin(), nums.end());
        int mid = nums[(m*n)/2];
        int res = 0;
        for (int i = 0; i < m*n; ++i) {
            if (abs(nums[i]-mid)%x != 0) {
                return -1;
            }
            res += abs(nums[i]-mid)/x;
        }
        return res;
    }
};