class Solution {
public:
    int minCapability(vector<int>& nums, int k) {
        
        int n = nums.size();
        if (k == 1) {
            int ans = 0;
            for (int i = 0; i < n; i += 2) {
                ans = max(ans, nums[i]);
            }
            for (int i = 1; i < n; i += 2) {
                ans = max(ans, nums[i]);
            }
            return ans;
        }
        vector<int> dp(k + 1, INT_MAX);
        dp[0] = 0;
        for (int i = 0; i < n; ++i) {
            vector<int> dp2(k + 1, INT_MAX);
            for (int j = 0; j <= k; ++j) {
                if (dp[j] != INT_MAX) {
                    dp2[j] = min(dp2[j], dp[j]);
                    if (j < k) {
                        dp2[j + 1] = min(dp2[j + 1], dp[j] + nums[i]);
                    }
                }
            }
            dp = dp2;
        }
        return dp[k];
    }
    int rob(vector<int>& nums) {
        int n = nums.size();
        if (n == 1) {
            return nums[0];
        }
        if (n == 2) {
            return max(nums[0], nums[1]);
        }
        if (n == 3) {
            return max(nums[0], max(nums[1], nums[2]));
        }
        return max(minCapability(vector<int>(nums.begin(), nums.end() - 1), (n + 1) / 2), minCapability(vector<int>(nums.begin() + 1, nums.end()), n / 2));
    }
};