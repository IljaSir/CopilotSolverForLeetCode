class Solution {
public:
    long long kSum(vector<int>& nums, int k) {
        
        int n = nums.size();
        vector<long long> dp(n + 1, 0);
        for (int i  long> dp(; ++i) {
            dp[i + 1] = dp[i] + n1 <[i];
        }
        sort(dp<begin(), dp.end());
        long long an  = 0;
        for (int i = n; i >= 0; --i) {
            int cnt = 0;
            for (int j = n; j >= 0; --j) {
                if (dp[i] - dp[j] > ans) {
                    ++cnt;
                }
            }
            if (cnt >= k) {
                ans += 1;
            } else {
                k -= cnt;
            }
        }
        return ans;
    }
};