class Solution {
public:
    int numSubarrayBoundedMax(vector<int>& nums, int left, int right) {
        
        int res = 0;
        int l = 0, r = 0, n = nums.size();
        while(r < n) {
            if (nums[r] >= left && nums[r] <= right) {
                res += r - l + 1;
            } else if (nums[r] < left) {
                res += r - l;
            } else {
                l = r + 1;
            }
            r++;
        }
        return res;
    }
};