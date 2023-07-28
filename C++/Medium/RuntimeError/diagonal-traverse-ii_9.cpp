class Solution {
public:
    vector<int> findDiagonalOrder(vector<vector<int>>& nums) {
        
        vector<int> ans;
        int m = nums.size();
        int maxCol = 0;
        for (auto& row : nums) {
            maxCol = max(maxCol, (int)row.size());
        }
        for (int i = 0; i < m + maxCol - 1; ++i) {
            int row = i;
            for (int col = 0; col <= i; ++col) {
                if (row < 0 || col >= m) {
                    break;
                }
                if (col < nums[row].size()) {
                    ans.push_back(nums[row][col]);
                }
                row -= 1;
            }
        }
        return ans;
    }
};