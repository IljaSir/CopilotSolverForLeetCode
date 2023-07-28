class Solution {
public:
    int subarrayGCD(vector<int>& nums, int k) {
        
        int n = nums.size();
        vector<int> dp(k+1, 0);
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            if (num % k == 0) {
                dp[0]++;
            }
            for (int j = k; j >= 1; j--) {
                if (num % j == 0) {
                    dp[j] += dp[j - num % k];
                }
            }
        }
        return dp[0];
    }
};