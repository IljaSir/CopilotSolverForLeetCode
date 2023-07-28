class Solution {
public:
    long long countSubarrays(vector<int>& nums, long long k) {
        
        int n = nums.size();
        vector<long long> sum(n+1, 0);
        for (int i = 0; i < n; i++) {
            sum[i+1] = sum[i] + nums[i];
        }
        long long res = 0;
        deque<int> dq;
        for (int i = 0; i <= n; i++) {
            while (!dq.empty() && sum[i] <= sum[dq.back()]) {
                dq.pop_back();
            }
            while (!dq.empty() && sum[i] >= sum[dq.front()] + k) {
                res += i - dq.front();
                dq.pop_front();
            }
            dq.push_back(i);
        }
        return res;
    }
};