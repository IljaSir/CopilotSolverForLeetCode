class Solution {
public:
    int validSubarraySize(vector<int>& nums, int threshold) {
        
        int l = 0, r = nums.size();
        while (l < r) {
            int m = l + (r - l) / 2;
            if (valid(nums, m, threshold)) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        return (l == nums.size()) ? -1 : l;
    }
    
    bool valid(vector<int>& nums, int k, int threshold) {
        long sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        if (sum > k * threshold) {
            return true;
        }
        for (int i = k; i < nums.size(); i++) {
            sum += nums[i] - nums[i - k];
            if (sum > k * threshold) {
                return true;
            }
        }
        return false;
    }
};