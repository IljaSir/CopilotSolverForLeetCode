class Solution {
public:
    bool canPartitionKSubsets(vector<int>& nums, int k) {
        
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % k != 0) {
            return false;
        }
        int target = sum / k;
        vector<int> used(nums.size());
        return dfs(nums, used, 0, k, 0, 0, target);
    }
    bool dfs(vector<int>& nums, vector<int>& used, int start_index, int k, int cur_sum, int cur_num, int target) {
        if (k == 1) {
            return true;
        }
        if (cur_sum == target && cur_num > 0) {
            return dfs(nums, used, 0, k - 1, 0, 0, target);
        }
        for (int i = start_index; i < nums.size(); i++) {
            if (!used[i]) {
                used[i] = 1;
                if (dfs(nums, used, i + 1, k, cur_sum + nums[i], cur_num++, target)) {
                    return true;
                }
                used[i] = 0;
            }
        }
        return false;
    }
};