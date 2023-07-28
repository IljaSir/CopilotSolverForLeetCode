class Solution {
public:
    long long countSubarrays(vector<int>& nums, long long k) {
        
        long long ans = 0;
        int n = nums.size();
        vector<long long> pre(n + 1);
        for (int i = 0; i < n; i++) {
            pre[i + 1] = pre[i] + nums[i];
        }
        deque<int> q;
        for (int i = 0; i <= n; i++) {
            while (!q.empty() && pre[i] <= pre[q.back()]) {
                q.pop_back();
            }
            while (!q.empty() && pre[i] * (i - q.front()) >= k) {
                ans += i - q.front();
                q.pop_front();
            }
            q.push_back(i);
        }
        return ans;
    }
};