class Solution {
public:
    vector<int> getMaximumXor(vector<int>& nums, int maximumBit) {
        
        int n = nums.size();
        vector<int> ans(n);
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum ^= nums[i];
        }
        for (int i = 0; i < n; i++) {
            ans[n - i - 1] = sum ^ ((1 << maximumBit) - 1);
            sum ^= nums[n - i - 1];
        }
        return ans;
    }
};