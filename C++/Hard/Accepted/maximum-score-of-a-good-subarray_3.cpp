class Solution {
public:
    int maximumScore(vector<int>& nums, int k) {
        
        int n = nums.size();
        int left = k, right = k;
        int minVal = nums[k];
        int res = minVal;
        while (left > 0 || right < n - 1) {
            if (left == 0) {
                ++right;
            } else if (right == n - 1) {
                --left;
            } else if (nums[left - 1] < nums[right + 1]) {
                ++right;
            } else {
                --left;
            }
            minVal = min(minVal, min(nums[left], nums[right]));
            res = max(res, minVal * (right - left + 1));
        }
        return res;
    }
};