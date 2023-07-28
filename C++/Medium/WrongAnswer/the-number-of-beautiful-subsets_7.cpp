class Solution {
public:
    int beautifulSubsets(vector<int>& nums, int k) {
        
        int n = nums.size();
        vector<int> dp(1 << n);
        dp[0] = 1;
        unordered_map<int, int> mp;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < (1 << n); ++j) {
                if (j & (1 << i)) {
                    dp[j] += dp[j ^ (1 << i)];
                }
            }
        }
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < (1 << n); ++j) {
                if (j & (1 << i)) {
                    mp[nums[i] - nums[__builtin_ctz(j)]] += dp[j ^ (1 << i)];
                }
            }
        }
        int ans = 0;
        for (auto& p : mp) {
            if (p.first == k) {
                ans += p.second;
            }
        }
        return ans;
    }
};