class Solution {
public:
    int shortestSubarray(vector<int>& nums, int k) {
        
        int n = nums.size();
        vector<int> sum(n + 1, 0);
        for (int i = 0; i < n; i++) sum[i + 1] = sum[i] + nums[i];
        deque<int> q;
        int res = INT_MAX;
        for (int i = 0; i < sum.size(); i++) {
            while (!q.empty() && sum[i] - sum[q.front()] >= k) {
                res = min(res, i - q.front());
                q.pop_front();
            }
            while (!q.empty() && sum[i] <= sum[q.back()]) {
                q.pop_back();
            }
            q.push_back(i);
        }
        return res == INT_MAX ? -1 : res;
    }
};