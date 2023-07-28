class Solution {
public:
    vector<int> getMaximumXor(vector<int>& nums, int maximumBit) {
        
        int n = nums.size();
        int x = 0;
        for (auto num : nums) {
            x ^= num;
        }
        vector<int> ans;
        for (int i = n - 1; i >= 0; --i) {
            ans.push_back(x ^ ((1 << maximumBit) - 1));
            x ^= nums[i];
        }
        return ans;
    }
};