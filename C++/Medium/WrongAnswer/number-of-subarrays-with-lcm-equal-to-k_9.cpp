class Solution {
public:
    int subarrayLCM(vector<int>& nums, int k) {
        
        int n = nums.size();
        vector<int> dp(n+1, 0);
        for (int i = 1; i <= n; i++) {
            dp[i] = nums[i-1] / __gcd(nums[i-1], dp[i-1]) * dp[i-1];
        }
        int ans = 0;
        unordered_map<int, int> cnt;
        for (int i = 0; i <= n; i++) {
            if (dp[i] % k == 0) ans += cnt[0];
            ans += cnt[dp[i] % k];
            cnt[dp[i] % k]++;
        }
        return ans;
    }
};