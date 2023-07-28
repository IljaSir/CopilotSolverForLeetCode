class Solution {
public:
    vector<int> findDiagonalOrder(vector<vector<int>>& nums) {
        
        int n = nums.size();
        int m = 0;
        for (auto &v : nums) m = max(m, (int)v.size());
        vector<int> res;
        for (int i = 0; i < n + m - 1; i++) {
            for (int j = 0; j < n; j++) {
                int k = i - j;
                if (k >= 0 && k < m) {
                    if (k < nums[j].size()) res.push_back(nums[j][k]);
                }
            }
        }
        return res;
    }
};