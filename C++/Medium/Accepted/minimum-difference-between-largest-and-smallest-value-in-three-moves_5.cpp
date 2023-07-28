class Solution {
public:
    int minDifference(vector<int>& nums) {
        
        if (nums.size() <= 4) return 0;
        sort(nums.begin(), nums.end());
        int ans = INT_MAX;
        for (int i = 0; i < 4; i++) {
            ans = min(ans, nums[nums.size() - 1 - (3 - i)] - nums[i]);
        }
        return ans;
    }
};