class Solution {
public:
    bool canPartitionKSubsets(vector<int>& nums, int k) {
        
        int sum = 0;
        for (auto n : nums) sum += n;
        if (sum % k != 0) return false;
        int target = sum / k;
        sort(nums.begin(), nums.end());
        if (nums.back() > target) return false;
        vector<bool> visited(nums.size());
        return search(nums, visited, 0, k, 0, target);
    }
};