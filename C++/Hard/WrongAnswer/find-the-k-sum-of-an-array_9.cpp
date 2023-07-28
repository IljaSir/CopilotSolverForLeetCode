class Solution {
public:
    long long kSum(vector<int>& nums, int k) {
        
        long long ans = 0;
        int n = nums.size();
        vector<vector<long long>> dp(n + 1, vector<long long>(k + 1, 0));
        dp[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            dp[i][0] = 1;
            for (int j = 1; j <= k; j++) {
                dp[i][j] = dp[i - 1][j];
                if (nums[i - 1] >= 0) {
                    dp[i][j] += dp[i - 1][j - 1];
                } else {
                    if (j > 1) {
                        dp[i][j] += dp[i - 1][j - 2];
                    }
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] >= 0) {
                ans += dp[i][k];
            } else {
                if (k > 1) {
                    ans += dp[i][k - 1];
                }
            }
        }
        return ans;
    }
    int kthLargestValue(vector<vector<int>>& matrix, int k) {
        int n = matrix.size();
        int m = matrix[0].size();
        vector<vector<int>> pre(n + 1, vector<int>(m + 1));
        vector<int> nums;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                pre[i][j] = pre[i - 1][j] ^ pre[i][j - 1] ^ pre[i - 1][j - 1] ^ matrix[i - 1][j - 1];
                nums.push_back(pre[i][j]);
            }
        }
        sort(nums.begin(), nums.end());
        return nums[nums.size() - k];
    }
};