class Solution {
public:
    int maximumScore(vector<int>& nums, int k) {
        
        int n = nums.size();
        int ans = nums[k];
        int min_val = nums[k];
        int l = k, r = k;
        while (l > 0 || r < n - 1) {
            if (l == 0) {
                ++r;
            } else if (r == n - 1) {
                --l;
            } else if (nums[l - 1] < nums[r + 1]) {
                ++r;
            } else {
                --l;
            }
            min_val = min(min_val, nums[l]);
            min_val = min(min_val, nums[r]);
            ans = max(ans, min_val * (r - l + 1));
        }
        return ans;
    }
};