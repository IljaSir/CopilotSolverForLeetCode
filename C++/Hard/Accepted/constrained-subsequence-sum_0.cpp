class Solution {
public:
    int constrainedSubsetSum(vector<int>& nums, int k) {
        
        int n = nums.size();
        vector<int> dp(n);
        deque<int> q;
        dp[0] = nums[0];
        q.push_back(0);
        for (int i = 1; i < n; ++i) {
            dp[i] = nums[i] + max(0, dp[q.front()]);
            while (!q.empty() && dp[q.back()] <= dp[i]) q.pop_back();
            q.push_back(i);
            if (i - q.front() >= k) q.pop_front();
        }
        return *max_element(dp.begin(), dp.end());
    }
};