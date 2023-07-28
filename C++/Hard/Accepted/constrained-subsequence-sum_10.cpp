class Solution {
public:
    int constrainedSubsetSum(vector<int>& nums, int k) {
        
        int n = nums.size();
        int dp[n];
        int mx = INT_MIN;
        deque<int> dq;
        for (int i = 0; i < n; i++) {
            dp[i] = nums[i];
            if (!dq.empty()) {
                dp[i] = max(dp[i], nums[i] + dp[dq.front()]);
            }
            while (!dq.empty() && dp[dq.back()] < dp[i]) {
                dq.pop_back();
            }
            dq.push_back(i);
            if (dq.front() == i - k) {
                dq.pop_front();
            }
            mx = max(mx, dp[i]);
        }
        return mx;
    }
};