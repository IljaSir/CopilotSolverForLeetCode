class Solution {
public:
    int numSubarrayBoundedMax(vector<int>& nums, int left, int right) {
        
        int n = nums.size();
        int res = 0;
        int l = 0, r = 0;
        while(r < n) {
            if (nums[r] < left) {
                res += r - l;
            } else if (nums[r] > right) {
                l = r + 1;
            } else {
                int tmp = r;
                while(r < n && nums[r] <= right) r++;
                res += (r - l) * (r - tmp);
                l = r;
            }
            r++;
        }
        return res;
    }
};