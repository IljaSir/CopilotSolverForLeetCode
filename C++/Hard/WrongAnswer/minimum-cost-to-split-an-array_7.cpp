class Solution {
public:
    int minCost(vector<int>& nums, int k) {
        
        int n = nums.size();
        vector<int> dp(n + 1);
        vector<int> last(n, -1);
        for (int i = 0; i < n; ++i) {
            dp[i + 1] = dp[i] + k;
            if (last[nums[i]] >= 0) {
                dp[i + 1] = min(dp[i + 1], dp[last[nums[i]]] + k + i - last[nums[i]]);
            }
            last[nums[i]] = i;
        }
        return dp[n];
    }
};