class Solution {
public:
    vector<vector<int>> subsets(vector<int>& nums) {
        
        vector<vector<int>> res;
        vector<int> tmp;
        int n = nums.size();
        for (int i = 0; i < (1 << n); i++) {
            tmp.clear();
            for (int j = 0; j < n; j++) {
                if (i & (1 << j)) {
                    tmp.push_back(nums[j]);
                }
            }
            res.push_back(tmp);
        }
        return res;
    }
};