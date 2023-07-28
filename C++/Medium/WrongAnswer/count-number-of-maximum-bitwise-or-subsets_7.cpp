class Solution {
public:
    int countMaxOrSubsets(vector<int>& nums) {
        
        int n = nums.size();
        int maxBit = 0;
        for (int i = 0; i < n; ++i) {
            maxBit |= nums[i];
        }
        vector<int> cnt(maxBit + 1, 0);
        for (int i = 0; i < n; ++i) {
            for (int j = maxBit; j >= nums[i]; --j) {
                cnt[j] += cnt[j - nums[i]];
            }
            cnt[nums[i]] += 1;
        }
        return cnt[maxBit];
    }
};