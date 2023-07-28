class Solution {
public:
    long long minimumReplacement(vector<int>& nums) {
        
        int n = nums.size();
        int dp[n];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            if (i > 0 && nums[i] > nums[i-1]) {
                dp[i] = dp[i-1] + 1;
            }
            ans = max(ans, dp[i]);
        }
        return n - ans;
    }
};