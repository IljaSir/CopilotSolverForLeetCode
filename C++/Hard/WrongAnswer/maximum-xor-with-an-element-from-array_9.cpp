class Solution {
public:
    vector<int> maximizeXor(vector<int>& nums, vector<vector<int>>& queries) {
        
        int n = nums.size();
        sort(nums.begin(), nums.end());
        vector<int> ans;
        for (auto& q : queries) {
            int x = q[0], m = q[1], y = -1;
            for (int i = 31; i >= 0; --i) {
                int t = y | (1 << i);
                if (t <= m) {
                    auto it = lower_bound(nums.begin(), nums.end(), t);
                    if (it != nums.end() && *it <= m && (*it ^ x) > y) {
                        y = *it ^ x;
                    }
                }
            }
            ans.push_back(y);
        }
        return ans;
    }
};