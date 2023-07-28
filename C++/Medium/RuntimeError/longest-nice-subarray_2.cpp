class Solution {
public:
    int longestNiceSubarray(vector<int>& nums) {
        
        int n = nums.size();
        int res = 0;
        for (int i = 0; i < n; i++) {
            int mask = 0;
            for (int j = i; j < n; j++) {
                mask |= 1 << (nums[j] - 1);
                if ((mask & (mask >> 16)) == 0) {
                    res = max(res, j - i + 1);
                }
            }
        }
        return res;
    }
};