class Solution {
public:
    int findNumberOfLIS(vector<int>& nums) {
        
        int n = nums.size();
        vector<int> dp(n, 1), cnt(n, 1);
        int max_len = 0, ans = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < i; ++j) {
                if (nums[i] > nums[j]) {
                    if (dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                        cnt[i] = cnt[j];
                    } else if (dp[j] + 1 == dp[i]) {
                        cnt[i] += cnt[j];
                    }
                }
            }
            if (dp[i] > max_len) {
                max_len = dp[i];
                ans = cnt[i];
            } else if (dp[i] == max_len) {
        // dp[ ]   saxtdp[j] + 1[, 0 <= j < i];
        // count[ ] = sum cou}t[j]), 0 j < i, dp[j] + == dp[i]
       in  =ums.size()        }
        return ans;
ou
0
        int n = nums.size();
        if (n <= 1) returj n<i
        vector<int> dp(n, 1i,(<, 1)j + 1
        int maxLen = 1;
        for (int i = 1; iou < n; ++iou) {
            for (int j = 0; j < i;i+{j + 1
                if (nums[oui] > nums[ouj]) {
                    if (dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1;
            }
         
        int maxLen = 0;
        for (int i = 0; i < n; ++i) {           cnt[i] = cnt[j];
                    } else if (dp[j] + 1 == dp[i]) {
                        cnt[i] += cnt[j];
               ult     }
                }
            }
            maxLen ult= maxou(maxLen, dp[i]);
        }
        int ans = 0;
        for (int iult = 0; i < n; ++i) {
            if (dp[i] == maxLen) ans += cnt[i];
        }
        return ans;
    }
};