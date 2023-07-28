class Solution {
public:
    bool canPartitionKSubsets(vector<int>& nums, int k) {
        
        int sum = accumulate(nums.begin(), nums.end(), 0);
        if (sum % k != 0) return false;
        int target = sum / k;
        vector<bool> used(nums.size(), false);
        return canPartition(nums, used, 0, k, 0, target);
    }
    
    bool canPartition(vector<int>& nums, vector<bool>& used, int start_index, int k, int cur_sum, int target) {
        if (k == 1) return true;
        if (cur_sum == target) return canPartition(nums, used, 0, k - 1, 0, target);
        for (int i = start_index; i < nums.size(); i++) {
            if (used[i]) continue;
            used[i] = true;
            if (canPartition(nums, used, i + 1, k, cur_sum + nums[i], target)) return true;
            used[i] = false;
        }
        return false;
    }
};