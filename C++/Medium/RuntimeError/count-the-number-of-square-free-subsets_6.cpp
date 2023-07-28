class Solution {
public:
    int squareFreeSubsets(vector<int>& nums) {
        
        int n = nums.size();
        int mod = 1e9 + 7;
        vector<int> count(31);
        for (int x : nums) {
            count[x]++;
        }
        vector<int> dp(1 << 31);
        dp[0] = 1;
        for (int i = 1; i < (1 << 31); i++) {
            int j = __builtin_ctz(i);
            dp[i] = dp[i ^ (1 << j)] * (count[j] + 1) % mod;
        }
        int ans = 0;
        for (int i = 1; i < (1 << 31); i++) {
            int j = __builtin_ctz(i);
            int cnt = 0;
            for (int k = j; k < 31; k += j) {
                cnt += count[k];
            }
            if (cnt % 2 == 1) {
                ans = (ans - dp[i] + mod) % mod;
            } else {
                ans = (ans + dp[i]) % mod;
            }
        }
        return ans;
    }
};