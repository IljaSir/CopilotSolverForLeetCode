class Solution {
public:
    int findUnsortedSubarray(vector<int>& nums) {
        
        int n = nums.size();
        int l = 0, r = n - 1;
        while (l < r && nums[l] <= nums[l + 1]) l++;
        while (l < r && nums[r] >= nums[r - 1]) r--;
        if (l == r) return 0;
        int minVal = INT_MAX, maxVal = INT_MIN;
        for (int i = l; i <= r; i++) {
            minVal = min(minVal, nums[i]);
            maxVal = max(maxVal, nums[i]);
        }
        while (l > 0 && nums[l - 1] > minVal) l--;
        while (r < n - 1 && nums[r + 1] < maxVal) r++;
        return r - l + 1;
    }
};