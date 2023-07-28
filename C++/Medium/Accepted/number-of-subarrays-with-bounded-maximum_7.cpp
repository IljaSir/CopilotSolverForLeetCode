class Solution {
public:
    int numSubarrayBoundedMax(vector<int>& nums, int left, int right) {
        
        int n = nums.size();
        int res = 0;
        int prev = 0;
        int l = 0;
        int r = 0;
        while (r < n) {
            if (nums[r] >= left && nums[r] <= right) {
                prev = r - l + 1;
                res += prev;
            } else if (nums[r] < left) {
                res += prev;
            } else {
                prev = 0;
                l = r + 1;
            }
            r++;
        }
        return res;
    }
};