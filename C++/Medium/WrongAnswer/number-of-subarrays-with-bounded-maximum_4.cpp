class Solution {
public:
    int numSubarrayBoundedMax(vector<int>& nums, int left, int right) {
        
        int res = 0;
        int l = 0, r = 0;
        int n = nums.size();
        while (r < n) {
            if (nums[r] < left) {
                res += r - l;
            } else if (nums[r] > right) {
                l = r + 1;
            } else {
                int tmp = r;
                while (tmp < n && nums[tmp] <= right) {
                    tmp++;
                }
                res += (tmp - r) * (r - l + 1);
                l = r = tmp;
            }
            r++;
        }
        return res;
    }
};