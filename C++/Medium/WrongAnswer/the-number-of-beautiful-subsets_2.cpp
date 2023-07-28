class Solution {
public:
    int beautifulSubsets(vector<int>& nums, int k) {
        
        int n = nums.size();
        int dp[1 << n];
        memset(dp, 0, sizeof(dp));
        dp[0] = 1;
        for (int i = 0; i < (1 << n); i++) {
            if (dp[i]) {
                for (int j = 0; j < n; j++) {
                    if (i & (1 << j)) continue;
                    bool ok = true;
                    for (int l = 0; l < n; l++) {
                        if (i & (1 << l)) {
                            if (abs(nums[l] - nums[j]) == k) {
                                ok = false;
                                break;
                            }
                        }
                    }
                    if (ok) dp[i | (1 << j)] += dp[i];
                }
            }
        }
        return dp[(1 << n) - 1];
    }
};