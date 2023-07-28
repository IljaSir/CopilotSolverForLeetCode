class Solution {
public:
    int shortestSubarray(vector<int>& nums, int k) {
        
        int n = nums.size();
        vector<int> sums(n+1, 0);
        for (int i = 0; i < n; ++i) {
            sums[i+1] = sums[i] + nums[i];
        }
        deque<int> dq;
        int ans = INT_MAX;
        for (int i = 0; i < n+1; ++i) {
            while (!dq.empty() && sums[i] <= sums[dq.back()]) {
                dq.pop_back();
            }
            while (!dq.empty() && sums[i] - sums[dq.front()] >= k) {
                ans = min(ans, i - dq.front());
                dq.pop_front();
            }
            dq.push_back(i);
        }
        return ans == INT_MAX ? -1 : ans;
    }
};