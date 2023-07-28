class Solution {
public:
    int numSubarrayBoundedMax(vector<int>& nums, int left, int right) {
        
        int n = nums.size();
        int l = -1, r = -1, res = 0;
        for (int i = 0; i < n; ++i) {
            if (nums[i] > right) l = i;
            if (nums[i] >= left) r = i;
            res += r - l;
        }
        return res;
    }
};