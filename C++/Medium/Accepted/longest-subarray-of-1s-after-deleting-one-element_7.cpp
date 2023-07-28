class Solution {
public:
    int longestSubarray(vector<int>& nums) {
        
        int n = nums.size();
        int l = 0, r = 0, k = 1, ans = 0, cnt = 0;
        while (r < n) {
            if (nums[r] == 0) {
                cnt++;
            }
            while (cnt > k) {
                if (nums[l] == 0) {
                    cnt--;
                }
                l++;
            }
            ans = max(ans, r - l + 1);
            r++;
        }
        return ans - 1;
    }
};