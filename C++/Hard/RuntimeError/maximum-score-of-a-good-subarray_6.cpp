class Solution {
public:
    int maximumScore(vector<int>& nums, int k) {
        
        int n = nums.size();
        int ans = nums[k];
        int l = k, r = k;
        while (l > 0 || r < n-1) {
            int nl = l > 0 ? l - 1 : -1;
            int nr = r < n-1 ? r + 1 : -1;
            int ml = nl >= 0 ? nums[nl] : INT_MAX;
            int mr = nr >= 0 ? nums[nr] : INT_MAX;
            if (ml < mr) {
                r = nr;
                ans = max(ans, (r-l+1) * min(nums[l], nums[r]));
            } else {
                l = nl;
                ans = max(ans, (r-l+1) * min(nums[l], nums[r]));
            }
        }
        return ans;
    }
};