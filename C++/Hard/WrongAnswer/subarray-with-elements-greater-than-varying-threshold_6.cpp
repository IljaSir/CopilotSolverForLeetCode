class Solution {
public:
    int validSubarraySize(vector<int>& nums, int threshold) {
        
        int l = 0, r = nums.size();
        while (l < r) {
            int m = (l + r) / 2;
            if (validSubarraySize(nums, threshold, m)) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        return l == nums.size() ? -1 : l;
    }
    bool validSubarraySize(vector<int>& nums, int threshold, int k) {
        long long sum = 0;
        for (int i = 0; i < k; ++i) {
            sum += nums[i];
        }
        if (sum > threshold * k) {
            return true;
        }
        for (int i = k; i < nums.size(); ++i) {
            sum += nums[i];
            sum -= nums[i - k];
            if (sum > threshold * k) {
                return true;
            }
        }
        return false;
    }
};