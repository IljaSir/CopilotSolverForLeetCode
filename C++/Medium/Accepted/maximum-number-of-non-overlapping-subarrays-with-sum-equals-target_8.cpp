class Solution {
public:
    int maxNonOverlapping(vector<int>& nums, int target) {
        
        int n = nums.size();
        vector<int> dp(n+1, 0);
        unordered_map<int, int> mp;
        int sum = 0;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            if (sum == target) {
                dp[i+1] = max(dp[i+1], dp[0]+1);
            }
            if (mp.find(sum-target) != mp.end()) {
                dp[i+1] = max(dp[i+1], dp[mp[sum-target]]+1);
            }
            dp[i+1] = max(dp[i+1], dp[i]);
            mp[sum] = i+1;
            ans = max(ans, dp[i+1]);
        }
        return ans;
    }
};