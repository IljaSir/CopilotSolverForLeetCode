class Solution {
public:
    int numSubarraysWithSum(vector<int>& nums, int goal) {
        
        int n = nums.size();
        vector<int> dp(n + 1, 0);
        int res = 0;
        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i - 1] + nums[i - 1];
            if (dp[i] >= goal) {
                int j = i - 1;
                while (j >= 0 && dp[i] - dp[j] <= goal) {
                    if (dp[i] - dp[j] == goal) {
                        res++;
                    }
                    j--;
                }
            }
        }
        return res;
    }
};