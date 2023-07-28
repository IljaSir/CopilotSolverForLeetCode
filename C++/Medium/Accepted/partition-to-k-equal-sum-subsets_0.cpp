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
        vector<int> groups(k);
        sort(nums.begin(), nums.end(), greater<int>());
        return dfs(nums, groups, 0, target);
    }

    bool dfs(vector<int>& nums, vector<int>& groups, int index, int target) {
        if (index == nums.size()) {
            return true;
        }
        int num = nums[index];
        for (int i = 0; i < groups.size(); ++i) {
            if (groups[i] + num <= target) {
                groups[i] += num;
                if (dfs(nums, groups, index + 1, target)) {
                    return true;
                }
                groups[i] -= num;
            }
            if (groups[i] == 0) {
                break;
            }
        }
        return false;
    }
};