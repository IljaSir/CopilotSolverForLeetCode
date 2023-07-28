class Solution {
public:
    vector<int> getMaximumXor(vector<int>& nums, int maximumBit) {
        
        int n = nums.size();
        vector<int> res(n);
        int x = 0;
        for (int i = 0; i < n; ++i) {
            x ^= nums[i];
        }
        for (int i = 0; i < n; ++i) {
            res[i] = x;
            x ^= nums[n - i - 1];
        }
        for (int i = 0; i < n; ++i) {
            res[i] = (1 << maximumBit) - 1 - res[i];
        }
        return res;
    }
};