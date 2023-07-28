class Solution {
public:
    int longestNiceSubarray(vector<int>& nums) {
        
        int n = nums.size();
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            int mask = 0;
            for (int j = i; j < n; ++j) {
                mask |= 1 << (nums[j] % 32);
                if ((mask & (mask >> 16)) && (mask & (mask >> 8)) && (mask & (mask >> 4)) && (mask & (mask >> 2)) && (mask & (mask >> 1))) {
                    ans = max(ans, j - i + 1);
                }
            }
        }
        return ans;
    }
};