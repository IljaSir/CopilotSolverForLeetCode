class Solution {
public:
    vector<int> findDiagonalOrder(vector<vector<int>>& nums) {
        
        vector<int> result;
        int maxRow = 0;
        for (int i = 0; i < nums.size(); i++) {
            maxRow = max(maxRow, (int) nums[i].size());
        }
        for (int i = 0; i < maxRow; i++) {
            int row = 0;
            int col = i;
            while (row < nums.size() && col >= 0) {
                if (col < nums[row].size()) {
                    result.push_back(nums[row][col]);
                }
                row++;
                col--;
            }
        }
        for (int i = 1; i < nums.size(); i++) {
            int row = i;
            int col = maxRow - 1;
            while (row < nums.size() && col >= 0) {
                if (col < nums[row].size()) {
                    result.push_back(nums[row][col]);
                }
                row++;
                col--;
            }
        }
        return result;
    }
};