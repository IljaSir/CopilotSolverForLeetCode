class Solution {
public:
    long long countSubarrays(vector<int>& nums, long long k) {
        
        int n = nums.size();
        vector<int> sum(n + 1, 0);
        for (int i = 0; i < n; i++) {
            sum[i + 1] = sum[i] + nums[i];
        }
        deque<int> q;
        long long ans = 0;
        for (int i = 0; i <= n; i++) {
            while (!q.empty() && sum[i] <= sum[q.back()]) {
                q.pop_back();
            }
            while (!q.empty() && sum[i] >= sum[q.front()] + k) {
                ans += q.back() - q.front();
                q.pop_front();
            }
            q.push_back(i);
        }
        while (!q.empty()) {
            ans += q.back() - q.front();
            q.pop_front();
        }
        return ans;
    }
};