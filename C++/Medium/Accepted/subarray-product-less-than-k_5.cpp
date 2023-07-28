class Solution {
public:
    int numSubarrayProductLessThanK(vector<int>& nums, int k) {
        
        int n = nums.size();
        int ans = 0;
        int l = 0, r = 0, p = 1;
        while (r < n) {
            p *= nums[r];
            while (l <= r && p >= k) p /= nums[l++];
            ans += r - l + 1;
            r++;
        }
        return ans;
    }
};