class Solution {
public:
    vector<int> getMaximumXor(vector<int>& nums, int maximumBit) {
        
        int n = nums.size();
        vector<int> ans(n);
        int x = 0;
        for (int i = 0; i < n; i++) {
            x ^= nums[i];
            ans[i] = x ^ (1 << maximumBit) - 1;
        }
        reverse(ans.begin(), ans.end());
        return ans;
    }
};