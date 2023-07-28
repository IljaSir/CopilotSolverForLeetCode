class Solution {
public:
    int longestSubarray(vector<int>& nums) {
        
        int n = nums.size();
        int res = 0, cnt = 0, l = 0, r = 0;
        while (r < n) {
            if (nums[r] == 1) {
                cnt++;
            }
            while (l <= r && cnt < r - l + 1) {
                if (nums[l] == 1) {
                    cnt--;
                }
                l++;
            }
            res = max(res, r - l);
            r++;
        }
        return res;
    }
};