class Solution {
public:
    int minimumDeletions(vector<int>& nums) {
        
        int n = nums.size();
        int res = n;
        int l = 0, r = n-1;
        int mn = nums[0], mx = nums[n-1];
        while (l < n && nums[l] == mn) l++;
        while (r >= 0 && nums[r] == mx) r--;
        if (l > r) return 0;
        if (l == r) return 1;
        res = min(res, l + n-1-r);
        while (l < r) {
            if (nums[l] < nums[r]) {
                mn = nums[l];
                while (l < n && nums[l] == mn) l++;
                res = min(res, l + n-1-r);
            } else {
                mx = nums[r];
                while (r >= 0 && nums[r] == mx) r--;
                res = min(res, l + n-1-r);
            }
        }
        return res;
    }
};