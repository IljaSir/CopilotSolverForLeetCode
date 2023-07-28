class Solution {
public:
    int minIncrementForUnique(vector<int>& nums) {
        
        if (nums.size() == 0) return 0;
        sort(nums.begin(), nums.end());
        int n = nums.size();
        int count = 0;
        for (int i = 1; i < n; i++) {
            if (nums[i] <= nums[i-1]) {
                count += nums[i-1] - nums[i] + 1;
                nums[i] = nums[i-1] + 1;
            }
        }
        return count;
    }
};