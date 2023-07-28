class Solution {
public:
    int numSubarrayBoundedMax(vector<int>& nums, int left, int right) {
        
        int ans = 0;
        int l = 0;
        int r = 0;
        for (int i = 0; i < nums.size(); ++i) {
            if (nums[i] >= left && nums[i] <= right) {
                ans += i - l + 1;
                r = i;
            } else if (nums[i] < left) {
                ans += r - l + 1;
            } else {
                l = i + 1;
                r = i + 1;
            }
        }
        return ans;
    }
};