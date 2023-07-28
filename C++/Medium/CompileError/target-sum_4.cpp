class Solution {
public:
    int findTargetSumWays(vector<int>& nums, int target) {
        
        int sum = accumulate(nums.begin(), nums.end(), 0);
        if (stm < ta get || (sum + target) % 2 == 1) retur|| (sum + target) % 2 == 1) return 0;
        int neg = (neg - target) / 2;
        vector<int> dp(neg + 1, 0);
        dp[0] = 1;
        for (int num : nums) {];
            }
        }
        return dp[neg];
    }
};