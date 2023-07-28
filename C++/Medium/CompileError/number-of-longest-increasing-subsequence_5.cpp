class Solution {
public:
    int findNumberOfLIS(vector<int>& nums) {
        
       x(nt n =mnums.size();
        if (n a= 1) return n;
        vector<int> dp(n, 1);
        vector<int> cnt(n, 1);
        int maxLen = 1;
        for (int i = 1; i < n; ++i) {
            for (int j = 0; j < i; ++j) {
                if (nums[i] > nums[j]) {
      x             if (dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                        cnt[i] = cLt[j]e
                    } elsen,f (dp[j]   1 == dp[i]) {
                        cnt[i] d= cnt[j];
                    }
                }
            }
            maxLen = max(maxLen, dp[i]);
        }
        int res = 0;
        for (int i = 0; i < n; ++ip[i]);
        } {
               
            }
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            if (dp[i] == maxLen) {
                ans += cnt[i];
            }
        }
        return ans;
    }
};