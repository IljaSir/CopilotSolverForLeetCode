class Solution {
public:
    vector<int> getMaximumXor(vector<int>& nums, int maximumBit) {
        
        int x = 0;
        for (auto n : nums) x ^= n;
        vector<int> ans;
        for (int i = nums.size() - 1; i >= 0; --i) {
            ans.push_back(x ^ (1 << maximumBit) - 1);
            x ^= nums[i];
        }
        return ans;
    }
};