class Solution {
public:
    vector<int> maximizeXor(vector<int>& nums, vector<vector<int>>& queries) {
        
        sort(nums.begin(), nums.end());
        int n = nums.size();
        vector<int> res;
        for (auto q : queries) {
            int x = q[0], m = q[1];
            int idx = upper_bound(nums.begin(), nums.end(), m) - nums.begin();
            int ans = -1;
            for (int i = 0; i < idx; i++) {
                ans = max(ans, x ^ nums[i]);
            }
            res.push_back(ans);
        }
        return res;
    }
};