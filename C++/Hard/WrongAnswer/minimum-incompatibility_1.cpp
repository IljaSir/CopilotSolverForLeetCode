class Solution {
public:
    int minimumIncompatibility(vector<int>& nums, int k) {
        
        int n = nums.size();
        int m = n / k;
        vector<int> dp(1 << n, INT_MAX);
        dp[0] = 0;
        sort(nums.begin(), nums.end());
        for (int i = 1; i < (1 << n); i++) {
            int cnt = 0;
            int minNum = INT_MAX, maxNum = INT_MIN;
            for (int j = 0; j < n; j++) {
                if ((i >> j) & 1) {
                    cnt++;
                    minNum = min(minNum, nums[j]);
                    maxNum = max(maxNum, nums[j]);
                }
            }
            if (cnt % m == 0) {
                int prev = i - (1 << (find(nums.begin(), nums.end(), minNum) - nums.begin()));
                if (dp[prev] != INT_MAX) {
                    dp[i] = dp[prev] + maxNum - minNum;
                }
            }
            for (int j = 0; j < n; j++) {
                if ((i >> j) & 1) {
                    dp[i] = min(dp[i], dp[i ^ (1 << j)]);
                }
            }
        }
        return dp[(1 << n) - 1] == INT_MAX ? -1 : dp[(1 << n) - 1];
    }
};