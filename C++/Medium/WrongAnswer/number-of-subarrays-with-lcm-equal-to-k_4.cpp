class Solution {
public:
    int subarrayLCM(vector<int>& nums, int k) {
        
        int n = nums.size();
        vector<int> dp(k, 0);
        int ans = 0;
        int lcm = 1;
        for (int i = 0; i < n; i++) {
            lcm = lcm * nums[i] / gcd(lcm, nums[i]);
            lcm %= k;
            if (lcm == 0) ans++;
            ans += dp[lcm];
            dp[lcm]++;
        }
        return ans;
    }
};