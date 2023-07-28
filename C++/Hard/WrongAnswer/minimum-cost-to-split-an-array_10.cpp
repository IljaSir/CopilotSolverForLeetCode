class Solution {
public:
    int minCost(vector<int>& nums, int k) {
        
        int n = nums.size();
        vector<int> dp(n + 1, 0);
        vector<int> last(n, -1);
        vector<int> cost(n + 1, 0);
        for (int i = 0; i < n; ++i) {
            dp[i + 1] = dp[i] + 1;
            cost[i + 1] = cost[i] + 1;
            if (last[nums[i]] >= 0) {
                int l = last[nums[i]];
                dp[i + 1] = min(dp[i + 1], dp[l] + (i - l - cost[l]));
                cost[i + 1] = cost[l] + (i - l);
            }
            last[nums[i]] = i;
        }
        return dp[n];
    }
};