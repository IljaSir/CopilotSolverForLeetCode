class Solution {
public:
    int waysToMakeFair(vector<int>& nums) {
        
        int n = nums.size();
        int odd = 0, even = 0;
        for (int i = 0; i < n; ++i) {
            if (i % 2 == 0) {
                even += nums[i];
            } else {
                odd += nums[i];
            }
        }
        int ans = 0;
        int odd1 = 0, even1 = 0;
        for (int i = 0; i < n; ++i) {
            if (i % 2 == 0) {
                even -= nums[i];
                if (even1 + odd == odd1 + even) {
                    ++ans;
                }
                even1 += nums[i];
            } else {
                odd -= nums[i];
                if (even1 + odd == odd1 + even) {
                    ++ans;
                }
                odd1 += nums[i];
            }
        }
        return ans;
    }
};