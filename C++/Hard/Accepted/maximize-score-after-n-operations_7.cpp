class Solution {
public:
    int maxScore(vector<int>& nums) {
        
        int n = nums.size();
        vector<int> dp(1 << n, 0);
        for (int i = 0; i < (1 << n); i++) {
            int cnt = 0;
            for (int j = 0; j < n; j++) {
                if (i & (1 << j)) cnt++;
            }
            if (cnt % 2 == 1) continue;
            for (int j = 0; j < n; j++) {
                if (i & (1 << j)) {
                    for (int k = j + 1; k < n; k++) {
                        if (i & (1 << k)) {
                            dp[i] = max(dp[i], dp[i - (1 << j) - (1 << k)] + (cnt / 2) * __gcd(nums[j], nums[k]));
                        }
                    }
                }
            }
        }
        return dp[(1 << n) - 1];
    }
};