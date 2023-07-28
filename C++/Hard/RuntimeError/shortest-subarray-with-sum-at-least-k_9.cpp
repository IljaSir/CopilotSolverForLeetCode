class Solution {
public:
    int shortestSubarray(vector<int>& nums, int k) {
        
        int n = nums.size();
        vector<int> cumSum(n+1,0);
        for (int i=1; i<=n; i++) {
            cumSum[i] = cumSum[i-1] + nums[i-1];
        }
        deque<int> dq;
        int ans = n + 1;
        for (int i=0; i<=n; i++) {
            while (!dq.empty() && cumSum[i] - cumSum[dq.front()] >= k) {
                ans = min(ans, i - dq.front());
                dq.pop_front();
            }
            while (!dq.empty() && cumSum[i] <= cumSum[dq.back()]) {
                dq.pop_back();
            }
            dq.push_back(i);
        }
        return ans == n + 1 ? -1 : ans;
    }
};