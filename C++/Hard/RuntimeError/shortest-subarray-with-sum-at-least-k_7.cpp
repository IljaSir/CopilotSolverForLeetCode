class Solution {
public:
    int shortestSubarray(vector<int>& nums, int k) {
        
        int n = nums.size();
        int ans = INT_MAX;
        vector<int> sum(n+1, 0);
        for (int i = 1; i <= n; i++) {
            sum[i] = sum[i-1] + nums[i-1];
        }
        deque<int> q;
        for (int i = 0; i <= n; i++) {
            while (!q.empty() && sum[i] - sum[q.front()] >= k) {
                ans = min(ans, i - q.front());
                q.pop_front();
            }
            while (!q.empty() && sum[i] <= sum[q.back()]) {
                q.pop_back();
            }
            q.push_back(i);
        }
        return ans == INT_MAX ? -1 : ans;
    }
};