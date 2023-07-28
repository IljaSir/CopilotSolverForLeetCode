class Solution {
public:
    int shortestSubarray(vector<int>& nums, int k) {
        
        int n = nums.size();
        int ans = n + 1;
        vector<int> sum(n + 1);
        for (int i = 0; i < n; i++) {
            sum[i + 1] = sum[i] + nums[i];
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
        return ans == n + 1 ? -1 : ans;
    }
};