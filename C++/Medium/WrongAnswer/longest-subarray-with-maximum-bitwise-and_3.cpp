class Solution {
public:
    int longestSubarray(vector<int>& nums) {
        
        int n = nums.size();
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            int mx = nums[i];
            for (int j = i + 1; j < n; ++j) {
                mx = max(mx, nums[j]);
                if (mx == (mx & nums[j])) {
                    ans = max(ans, j - i);
                }
            }
        }
        return ans;
    }
};