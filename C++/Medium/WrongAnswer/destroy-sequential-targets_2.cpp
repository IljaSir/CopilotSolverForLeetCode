class Solution {
public:
    int destroyTargets(vector<int>& nums, int space) {
        
        sort(nums.begin(), nums.end());
        int n = nums.size();
        vector<int> dp(n, 1);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if ((nums[i] - nums[j]) % space == 0) {
                    dp[i] = max(dp[i], dp[j] + 1);
                }
            }
        }
        return *max_element(dp.begin(), dp.end());
    }
};