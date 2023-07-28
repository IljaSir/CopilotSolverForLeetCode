class Solution {
public:
    bool canPartitionKSubsets(vector<int>& nums, int k) {
        
        int sum = accumulate(nums.begin(), nums.end(), 0);
        if (sum % k != 0) return false;
        int target = sum / k;
        vector<bool> used(nums.size(), false);
        return dfs(nums, k, 0, 0, target, used);
    }
    
    bool dfs(vector<int>& nums, int k, int start, int curSum, int target, vector<bool>& used) {
        if (k == 1) return true;
        if (curSum == target) return dfs(nums, k-1, 0, 0, target, used);
        for (int i = start; i < nums.size(); ++i) {
            if (used[i]) continue;
            used[i] = true;
            if (dfs(nums, k, i+1, curSum+nums[i], target, used)) return true;
            used[i] = false;
        }
        return false;
    }
};