class Solution {
public:
    vector<int> getMaximumXor(vector<int>& nums, int maximumBit) {
        
        int n = nums.size();
        vector<int> ans(n);
        int x = 0;
        for (int a: nums) {
            x ^= a;
        }
        for (int i = 0; i < n; i++) {
            ans[i] = x;
            x ^= nums[n - 1 - i];
        }
        for (int i = 0; i < n; i++) {
            ans[i] = (1 << maximumBit) - 1 - ans[i];
        }
        return ans;
    }
};