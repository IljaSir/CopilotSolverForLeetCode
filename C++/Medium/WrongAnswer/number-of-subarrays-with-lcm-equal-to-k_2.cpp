class Solution {
public:
    int subarrayLCM(vector<int>& nums, int k) {
        
        int n = nums.size();
        vector<int> dp(n, 0);
        dp[0] = nums[0];
        for (int i = 1; i < n; ++i) {
            dp[i] = gcd(dp[i-1], nums[i]);
        }
        int res = 0;
        for (int i = 0; i < n; ++i) {
            if (dp[i] == k) {
                ++res;
            }
            for (int j = i+1; j < n; ++j) {
                int lcm = dp[j] / gcd(dp[j], nums[i]);
                if (lcm == k) {
                    ++res;
                }
            }
        }
        return res;
    }
    int gcd(int a, int b) {
        if (a < b) {
            return gcd(b, a);
        }
        if (a % b == 0) {
            return b;
        }
        return gcd(b, a%b);
    }
};