class Solution {
public:
    bool canPartitionKSubsets(vector<int>& nums, int k) {
        
        vector<int> sum(k, 0);
        int total = 0;
        for (int i = 0; i < nums.size(); i++) {
            total += nums[i];
        }
        if (total % k != 0) {
            return false;
        }
        int target = total / k;
        sort(nums.begin(), nums.end());
        if (nums.back() > target) {
            return false;
        }
        return helper(nums, nums.size() - 1, sum, target);
    }
    bool helper(vector<int>& nums, int index, vector<int>& sum, int target) {
        if (index < 0) {
            return true;
        }
        for (int i = 0; i < sum.size(); i++) {
            if (sum[i] + nums[index] <= target) {
                sum[i] += nums[index];
                if (helper(nums, index - 1, sum, target)) {
                    return true;
                }
                sum[i] -= nums[index];
            }
        }
        return false;
    }
};