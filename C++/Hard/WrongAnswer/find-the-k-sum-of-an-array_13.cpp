class Solution {
public:
    long long kSum(vector<int>& nums, int k) {
        
        long long ans = 0;
        int n = nums.size();
        vector<long long> dp(n+1, 0);
        for (int i = 1; i <= n; ++i) {
            dp[i] = dp[i-1] + nums[i-1];
        }
        priority_queue<long long, vector<long long>, greater<long long>> q;
        for (int i = 1; i <= n; ++i) {
            q.push(dp[i]);
            if (q.size() > k) {
                q.pop();
            }
        }
        while (!q.empty()) {
            ans += q.top();
            q.pop();
        }
        return ans;
    }
};