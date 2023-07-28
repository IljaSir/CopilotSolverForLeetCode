class Solution {
public:
    int subarrayGCD(vector<int>& nums, int k) {
        
        vector<int> dp(k, 0);
        for (auto n : nums) {
            vector<int> next(k, 0);
            for (auto i = 1; i < k; i++) {
                if (n % k == i) {
                    next[i] = dp[i] + 1;
                }
                next[__gcd(i, n % k)] += dp[i];
            }
            dp = next;
        }
        return dp[0] + 1;
    }
};