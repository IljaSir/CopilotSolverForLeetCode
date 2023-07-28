class Solution {
public:
    vector<int> findDiagonalOrder(vector<vector<int>>& nums) {
        
        int m = nums.size();
        int n = 0;
        for (int i = 0; i < m; i++) {
            n = max(n, (int)nums[i].size());
        }
        int max_len = m + n - 1;
        vector<int> ans;
        for (int i = 0; i < max_len; i++) {
            int x = i < n ? i : n - 1;
            int y = i < n ? 0 : i - n + 1;
            while (x >= 0 && y < m) {
                if (x < nums[y].size()) {
                    ans.push_back(nums[y][x]);
                }
                x--;
                y++;
            }
        }
        return ans;
    }
};