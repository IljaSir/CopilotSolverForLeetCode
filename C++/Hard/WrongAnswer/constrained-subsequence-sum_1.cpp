class Solution {
public:
    int constrainedSubsetSum(vector<int>& nums, int k) {
        
        int n = nums.size();
        vector<int> dp(n);
        deque<int> q;
        for (int i = 0; i < n; ++i) {
            dp[i] = nums[i] + (q.empty() ? 0 : q.front());
            while (!q.empty() && q.back() < dp[i]) {
                q.pop_back();
            }
            q.push_back(dp[i]);
            if (i >= k && q.front() == dp[i - k]) {
                q.pop_front();
            }
        }
        return *max_element(dp.begin(), dp.end());
    }
};