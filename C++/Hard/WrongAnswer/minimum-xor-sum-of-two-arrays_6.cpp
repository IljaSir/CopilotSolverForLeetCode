class Solution {
public:
    int minimumXORSum(vector<int>& nums1, vector<int>& nums2) {
        
        int n = nums1.size();
        int m = nums2.size();
        int dp[1 << n];
        memset(dp, 0, sizeof(dp));
        for (int i = 0; i < (1 << n); i++) {
            int x = __builtin_popcount(i);
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) == 0) {
                    dp[i | (1 << j)] = max(dp[i | (1 << j)], dp[i] + (nums1[x] ^ nums2[j]));
                }
            }
        }
        return dp[(1 << n) - 1];
    }
};