class Solution {
public:
    int longestSubarray(vector<int>& nums) {
        
        int n = nums.size();
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            int cur = nums[i];
            for (int j = i + 1; j < n; ++j) {
                cur &= nums[j];
                if (cur == 0) {
                    break;
                }
                ans = max(ans, j - i);
            }
        }
        return ans;
    }
};