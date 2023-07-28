class Solution {
public:
    int maximumScore(vector<int>& nums, int k) {
        
        int left = k, right = k, n = nums.size();
        int minV = nums[k], res = minV;
        while (left > 0 || right < n - 1) {
            if ((left > 0 ? nums[left - 1] : 0) < (right < n - 1 ? nums[right + 1] : 0)) {
                ++right;
            } else {
                --left;
            }
            minV = min(minV, nums[left]);
            minV = min(minV, nums[right]);
            res = max(res, minV * (right - left + 1));
        }
        return res;
    }
};