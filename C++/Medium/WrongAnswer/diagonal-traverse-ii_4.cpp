class Solution {
public:
    vector<int> findDiagonalOrder(vector<vector<int>>& nums) {
        
        vector<int> result;
        int m = nums.size();
        int n = 0;
        for (int i = 0; i < m; ++i) {
            n = max(n, (int)nums[i].size());
        }
        int maxLen = m + n - 1;
        vector<vector<int>> data(maxLen);
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < nums[i].size(); ++j) {
                data[i + j].push_back(nums[i][j]);
            }
        }
        for (int i = 0; i < maxLen; ++i) {
            if (i % 2 == 0) {
                for (int j = data[i].size() - 1; j >= 0; --j) {
                    result.push_back(data[i][j]);
                }
            }
            else {
                for (int j = 0; j < data[i].size(); ++j) {
                    result.push_back(data[i][j]);
                }
            }
        }
        return result;
    }
};