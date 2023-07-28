class Solution {
public:
    int shortestSubarray(vector<int>& nums, int k) {
        
        int n = nums.size();
        if (n == 0) return -1;
        vector<long long> sums(n+1, 0);
        for (int i = 0; i < n; i++) {
            sums[i+1] = sums[i] + nums[i];
        }
        deque<int> q;
        int ans = INT_MAX;
        for (int i = 0; i <= n; i++) {
            while (!q.empty() && sums[i] - sums[q.front()] >= k) {
                ans = min(ans, i - q.front());
                q.pop_front();
            }
            while (!q.empty() && sums[i] <= sums[q.back()]) {
                q.pop_back();
            }
            q.push_back(i);
        }
        return ans == INT_MAX ? -1 : ans;
    }
};