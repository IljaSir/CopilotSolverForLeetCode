class Solution {
public:
    long long countFairPairs(vector<int>& nums, int lower, int upper) {
        
        long long count = 0;
        int n = nums.size();
        vector<int> sorted(n);
        sort(nums.begin(), nums.end());
        for (int i = 0; i < n; ++i) {
            int low = lower - nums[i];
            int up = upper - nums[i];
            int l = lower_bound(nums.begin(), nums.begin() + i, low) - nums.begin();
            int u = upper_bound(nums.begin(), nums.begin() + i, up) - nums.begin();
            count += u - l;
        }
        return count;
    }
};