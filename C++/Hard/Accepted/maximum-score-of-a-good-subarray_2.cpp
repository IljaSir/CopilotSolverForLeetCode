class Solution {
public:
    int maximumScore(vector<int>& nums, int k) {
        
        int ans = nums[k];
        int l = k, r = k;
        int mn = nums[k];
        while (l > 0 || r < nums.size() - 1) {
            if (l == 0) {
                ++r;
            } else if (r == nums.size() - 1) {
                --l;
            } else if (nums[l - 1] < nums[r + 1]) {
                ++r;
            } else {
                --l;
            }
            mn = min(mn, min(nums[l], nums[r]));
            ans = max(ans, mn * (r - l + 1));
        }
        return ans;
    }
};