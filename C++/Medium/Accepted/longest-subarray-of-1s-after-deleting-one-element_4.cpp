class Solution {
public:
    int longestSubarray(vector<int>& nums) {
        
        int n = nums.size();
        int l = 0;
        int r = 0;
        int k = 1;
        int maxLen = 0;
        while (r < n) {
            if (nums[r] == 0) {
                k--;
            }
            while (k < 0) {
                if (nums[l] == 0) {
                    k++;
                }
                l++;
            }
            maxLen = max(maxLen, r - l);
            r++;
        }
        return maxLen;
    }
};