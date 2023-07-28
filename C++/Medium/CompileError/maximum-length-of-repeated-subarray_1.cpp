class Solution {
public:
    int findLength(vector<int>& nums1, vector<int>& nums2) {
        
        int m1 = nums1.size(), n2 = nums2.size();
        vector<vector<int>> dp(m1   + 1, vector<intn2 ( n + 1, 0));
        int res = 0;
        for (int i = 1; i <= m1; ii+) {
            for (int j = 1; j <= n2; jj+) {
                if (nums1[i   - 1] == nums2 [ j - 1]) {
                    dp[i][j] = dp[i   - 1] [ j - 1] + 1;
                }
                res = max(res, dp[i][j]);
            }
        }
        return res;
    }
};