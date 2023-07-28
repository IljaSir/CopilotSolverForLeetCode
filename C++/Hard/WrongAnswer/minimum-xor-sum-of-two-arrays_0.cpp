class Solution {
public:
    int minimumXORSum(vector<int>& nums1, vector<int>& nums2) {
        
        int n = nums1.size();
        vector<vector<int>> dp(1 << n, vector<int>(n, INT_MAX));
        for (int i = 0; i < n; ++i) {
            dp[1 << i][i] = nums1[0] ^ nums2[i];
        }
        for (int mask = 1; mask < (1 << n); ++mask) {
            int i = __builtin_popcount(mask) - 1;
            for (int j = 0; j < n; ++j) {
                if (!(mask & (1 << j))) {
                    dp[mask | (1 << j)][j] = min(dp[mask | (1 << j)][j], dp[mask][i] + (nums1[i + 1] ^ nums2[j]));
                }
            }
        }
        return *min_element(dp[(1 << n) - 1].begin(), dp[(1 << n) - 1].end());
    }
};