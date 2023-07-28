class Solution {
public:
    int maxNonOverlapping(vector<int>& nums, int target) {
        
        unordered_map<int, int> h;
        h[0] = 0;
        int sum = 0;
        int n = nums.size();
        vector<int> dp(n + 1, 0);
        for (int i = 1; i <= n; i++) {
            sum += nums[i - 1];
            dp[i] = dp[i - 1];
            if (h.find(sum - target) != h.end()) {
                dp[i] = max(dp[i], dp[h[sum - target]] + 1);
            }
            h[sum] = i;
        }
        return dp[n];
    }
};