class Solution {
public:
    int numSubarrayBoundedMax(vector<int>& nums, int left, int right) {
        
        int res = 0;
        int l = 0, r = 0;
        int cnt = 0;
        while (r < nums.size()) {
            if (nums[r] < left) {
                res += cnt;
            } else if (nums[r] >= left && nums[r] <= right) {
                cnt = r - l + 1;
                res += cnt;
            } else {
                l = r + 1;
                cnt = 0;
            }
            r++;
        }
        return res;
    }
};