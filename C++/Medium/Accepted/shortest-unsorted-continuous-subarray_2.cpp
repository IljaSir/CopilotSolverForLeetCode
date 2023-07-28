class Solution {
public:
    int findUnsortedSubarray(vector<int>& nums) {
        
        int n = nums.size();
        int l = 0, r = n - 1;
        while (l < n - 1 && nums[l] <= nums[l + 1]) l++;
        while (r > 0 && nums[r] >= nums[r - 1]) r--;
        if (l >= r) return 0;
        int mn = nums[l], mx = nums[l];
        for (int i = l + 1; i <= r; i++) {
            mn = min(mn, nums[i]);
            mx = max(mx, nums[i]);
        }
        while (l > 0 && nums[l - 1] > mn) l--;
        while (r < n - 1 && nums[r + 1] < mx) r++;
        return r - l + 1;
    }
};