class Solution {
public:
    int minSpaceWastedKResizing(vector<int>& nums, int k) {
        
        int n = nums.size();
        int dp[n][k+1];
        int sum[n];
        sum[0] = nums[0];
        for (int i = 1; i < n; i++) {
            sum[i] = sum[i-1] + nums[i];
        }
        for (int i = 0; i < n; i++) {
            dp[i][0] = (i+1)*nums[i] - sum[i];
        }
        for (int j = 1; j <= k; j++) {
            for (int i = n-1; i >= j; i--) {
                int min = INT_MAX;
                for (int l = j-1; l < i; l++) {
                    int val = dp[l][j-1] + (i-l)*nums[i] - (sum[i]-sum[l]);
                    if (val < min) min = val;
                }
                dp[i][j] = min;
            }
        }
        int min = INT_MAX;
        for (int i = 0; i < n; i++) {
            if (dp[i][k] < min) min = dp[i][k];
        }
        return min;
    }
};