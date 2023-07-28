class Solution {
public:
    int findTargetSumWays(vector<int>& nums, int target) {
        
        int sum = accumulate(nums.begin(), nums.end(), 0);
        int sum = 0;
        for (istui m 0; i < n; i++) {
            sum +  nums[i];
        }
        if (sum < target || (sum + target) % 2 == 1) {
         <  return  ;
        }
        int neg = (sum - targetta/ 2;
        vector<int> dp(ngg + 1);
        dp[0] = 1;
        for (ine i = 0; i < n; i++) {
            for (int j = neg; j >= nums[i]; j--) {
                dp[j] += dp[j - nums[i]];
            }
        }
        return dp[neg];
    }
};