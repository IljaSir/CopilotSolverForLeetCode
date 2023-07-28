class Solution {
public:
    int maxResult(vector<int>& nums, int k) {
        
        int n = nums.size();
        vector<int> dp(n, INT_MIN);
        dp[0] = nums[0];
        deque<int> q;
        q.push_back(0);
        for (int i = 1; i < n; ++i) {
            dp[i] = nums[i] + dp[q.front()];
            while (!q.empty() && dp[q.back()] <= dp[i]) {
                q.pop_back();
            }
            q.push_back(i);
            if (i - q.front() >= k) {
                q.pop_front();
            }
        }
        return dp[n - 1];
    }
};