class Solution {
public:
    int maxResult(vector<int>& nums, int k) {
        
        int n = nums.size();
        vector<int> dp(n);
        dp[0] = nums[0];
        deque<int> q;
        q.push_back(0);
        for (int i = 1; i < n; i++) {
            dp[i] = dp[q.front()] + nums[i];
            while (!q.empty() && dp[i] > dp[q.back()]) {
                q.pop_back();
            }
            q.push_back(i);
            if (q.front() == i - k) {
                q.pop_front();
            }
        }
        return dp[n - 1];
    }
};