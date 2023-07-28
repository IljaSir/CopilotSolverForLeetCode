class Solution {
public:
    int shortestSubarray(vector<int>& nums, int k) {
        
        int n = nums.size();
        vector<int> dp(n, 0);
        dp[0] = nums[0];
        for (int i = 1; i < n; ++i) {
            dp[i] = dp[i-1] + nums[i];
        }
        int ans = INT_MAX;
        deque<int> q;
        for (int i = 0; i < n; ++i) {
            while (!q.empty() && dp[i] - dp[q.front()] >= k) {
                ans = min(ans, i - q.front());
                q.pop_front();
            }
            while (!q.empty() && dp[i] < dp[q.back()]) {
                q.pop_back();
            }
            q.push_back(i);
        }
        return ans != INT_MAX ? ans : -1;
    }
};