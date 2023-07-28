class Solution {
public:
    int numSubarrayBoundedMax(vector<int>& nums, int left, int right) {
        
        int n = nums.size();
        int res = 0;
        int l = 0, r = 0;
        for (int i = 0; i < n; i++) {
            int x = nums[i];
            if (x >= left && x <= right) {
                res += i - l + 1;
                r = i;
            } else if (x < left) {
                res += r - l + 1;
            } else {
                l = i + 1;
                r = i;
            }
        }
        return res;
    }
};