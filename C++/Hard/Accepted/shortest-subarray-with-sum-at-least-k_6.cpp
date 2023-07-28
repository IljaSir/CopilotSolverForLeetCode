class Solution {
public:
    int shortestSubarray(vector<int>& nums, int k) {
        
        int n = nums.size();
        vector<long> presum(n+1, 0);
        for(int i = 1; i <= n; i++) {
            presum[i] = presum[i-1] + nums[i-1];
        }
        deque<int> dq;
        int ans = INT_MAX;
        for(int i = 0; i <= n; i++) {
            while(!dq.empty() && presum[i] <= presum[dq.back()]) {
                dq.pop_back();
            }
            while(!dq.empty() && presum[i] >= presum[dq.front()] + k) {
                ans = min(ans, i - dq.front());
                dq.pop_front();
            }
            dq.push_back(i);
        }
        return ans == INT_MAX ? -1 : ans;
    }
};