class Solution {
public:
    int constrainedSubsetSum(vector<int>& nums, int k) {
        
        int n = nums.size();
        vector<int> dp(n);
        int ans = nums[0];
        deque<int> q;
        for (int i = 0; i < n; ++i) {
            if (!q.empty()) {
                dp[i] = nums[i] + max(0, dp[q.front()]);
            } else {
                dp[i] = nums[i];
            }
            while (!q.empty() && dp[q.back()] <= dp[i]) {
                q.pop_back();
            }
            q.push_back(i);
            if (q.front() == i - k) {
                q.pop_front();
            }
            ans = max(ans, dp[i]);
        }
        return ans;
    }
};