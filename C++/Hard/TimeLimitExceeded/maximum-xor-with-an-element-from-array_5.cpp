class Solution {
public:
    vector<int> maximizeXor(vector<int>& nums, vector<vector<int>>& queries) {
        
        vector<int> res;
        sort(nums.begin(), nums.end());
        for (auto& q : queries) {
            int x = q[0], m = q[1];
            int idx = upper_bound(nums.begin(), nums.end(), m) - nums.begin();
            int max_xor = -1;
            for (int i = 0; i < idx; ++i) {
                max_xor = max(max_xor, x ^ nums[i]);
            }
            res.push_back(max_xor);
        }
        return res;
    }
};