class Solution {
public:
    long long findScore(vector<int>& nums) {
        
        int n = nums.size();
        vector<int> pre(n+1, 0);
        for (int i = 0; i < n; i++) {
            pre[i+1] = pre[i] + nums[i];
        }
        long long ans = 0;
        vector<int> dp(n, 0);
        for (int i = 0; i < n; i++) {
            int l = max(0, i-1);
            int r = min(n-1, i+1);
            int sum = pre[r+1] - pre[l];
            int mn = nums[i];
            if (l > 0) {
                mn = min(mn, nums[l-1]);
            }
            if (r < n-1) {
                mn = min(mn, nums[r+1]);
            }
            dp[i] = sum - mn;
        }
        for (int i = 0; i < n; i++) {
            ans += dp[i];
        }
        return ans;
    }
};