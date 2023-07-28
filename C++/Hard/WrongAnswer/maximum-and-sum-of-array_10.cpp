class Solution {
public:
    int maximumANDSum(vector<int>& nums, int numSlots) {
        
        int n = nums.size();
        int ans = 0;
        int mask = 0;
        for (int i = 15; i >= 0; --i) {
            mask |= (1 << i);
            int cnt = 0;
            for (int j = 0; j < n; ++j) {
                if ((nums[j] & mask) == mask) {
                    ++cnt;
                }
            }
            if (cnt >= numSlots) {
                ans |= (1 << i);
                numSlots -= min(cnt, numSlots);
            }
        }
        return ans;
    }
};