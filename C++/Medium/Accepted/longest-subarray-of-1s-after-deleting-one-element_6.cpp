class Solution {
public:
    int longestSubarray(vector<int>& nums) {
        
        int n = nums.size();
        int res = 0;
        int l = 0, r = 0;
        int k = 1;
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
            res = max(res, r - l);
            r++;
        }
        return res;
    }
};