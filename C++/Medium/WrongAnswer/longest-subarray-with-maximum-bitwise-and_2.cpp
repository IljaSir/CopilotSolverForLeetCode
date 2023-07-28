class Solution {
public:
    int longestSubarray(vector<int>& nums) {
        
        int n = nums.size();
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            int x = nums[i];
            for (int j = i; j < n; ++j) {
                x &= nums[j];
                if (x == 0) {
                    ans = max(ans, j - i);
                }
            }
        }
        return ans;
    }
};