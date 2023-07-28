class Solution {
public:
    bool canPartitionKSubsets(vector<int>& nums, int k) {
        
        int sum = accumulate(nums.begin(), nums.end(), 0);
        if (sum % k != 0) return false;
        int target = sum / k;
        sort(nums.rbegin(), nums.rend());
        if (nums[0] > target) return false;
        vector<int> bucket(k, 0);
        return dfs(nums, bucket, 0, target);
    }
    bool dfs(vector<int>& nums, vector<int>& bucket, int idx, int target) {
        if (idx == nums.size()) {
            return true;
        }
        for (int i = 0; i < bucket.size(); i++) {
            if (bucket[i] + nums[idx] > target) continue;
            bucket[i] += nums[idx];
            if (dfs(nums, bucket, idx + 1, target)) return true;
            bucket[i] -= nums[idx];
        }
        return false;
    }
};