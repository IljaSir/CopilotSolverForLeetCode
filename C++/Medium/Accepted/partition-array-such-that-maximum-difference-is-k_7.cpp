class Solution {
public:
    int partitionArray(vector<int>& nums, int k) {
        
        int n = nums.size();
        if (n == 0) return 0;
        if (n == 1) return 1;
        sort(nums.begin(), nums.end());
        int ans = 1;
        int min = nums[0], max = nums[0];
        for (int i = 1; i < n; i++) {
            if (nums[i] - min > k || max - nums[i] > k) {
                ans++;
                min = nums[i];
                max = nums[i];
            } else {
                min = min < nums[i] ? min : nums[i];
                max = max > nums[i] ? max : nums[i];
            }
        }
        return ans;
    }
};