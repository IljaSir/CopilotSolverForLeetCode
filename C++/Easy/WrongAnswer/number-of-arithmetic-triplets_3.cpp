class Solution {
public:
    int arithmeticTriplets(vector<int>& nums, int diff) {
        
        int n = nums.size();
        int ans = 0;
        vector<int> dp(n, 0);
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] - nums[j] == diff) {
                    if (j - diff >= 0) {
                        dp[i] += dp[j - diff];
                    }
                    dp[i]++;
                }
            }
            ans += dp[i];
        }
        return ans;
    }
};