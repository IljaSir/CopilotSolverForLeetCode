class Solution {
public:
    int minimumIncompatibility(vector<int>& nums, int k) {
        
        int n = nums.size();
        int m = n / k;
        int dp[1 << n];
        memset(dp, 0x3f, sizeof(dp));
        dp[0] = 0;
        for (int mask = 0; mask < (1 << n); ++mask) {
            int c = __builtin_popcount(mask);
            if (c % m == 0) {
                int mx = 0, mn = 0x3f3f3f3f;
                unordered_set<int> st;
                for (int i = 0; i < n; ++i) {
                    if (mask >> i & 1) {
                        mx = max(mx, nums[i]);
                        mn = min(mn, nums[i]);
                        st.insert(nums[i]);
                    }
                }
                if (st.size() == c) {
                    dp[mask] = mx - mn;
                }
            }
            for (int i = 0; i < n; ++i) {
                if (mask >> i & 1) {
                    dp[mask] = min(dp[mask], dp[mask ^ (1 << i)] + dp[1 << i]);
                }
            }
        }
        return dp[(1 << n) - 1] == 0x3f3f3f3f ? -1 : dp[(1 << n) - 1];
    }
};