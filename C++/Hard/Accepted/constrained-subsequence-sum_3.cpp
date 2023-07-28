class Solution {
public:
    int constrainedSubsetSum(vector<int>& nums, int k) {
        
        int n = nums.size();
        vector<int> dp(n, 0);
        int res = INT_MIN;
        deque<int> q;
        for (int i = 0; i < n; i++) {
            dp[i] = nums[i] + (q.empty() ? 0 : q.front());
            res = max(res, dp[i]);
            while (!q.empty() && q.back() < dp[i]) {
                q.pop_back();
            }
            if (dp[i] > 0) {
                q.push_back(dp[i]);
            }
            if (i >= k && !q.empty() && q.front() == dp[i - k]) {
                q.pop_front();
            }
        }
        return res;
    }
};