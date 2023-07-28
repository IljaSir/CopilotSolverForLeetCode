class Solution {
public:
    long long countSubarrays(vector<int>& nums, long long k) {
        
        int n = nums.size();
        vector<long long> prefix(n + 1);
        for (int i = 1; i <= n; i++) {
            prefix[i] = prefix[i - 1] + nums[i - 1];
        }
        long long ans = 0;
        deque<int> q;
        for (int i = 0; i <= n; i++) {
            while (!q.empty() && prefix[i] <= prefix[q.back()]) {
                q.pop_back();
            }
            while (!q.empty() && prefix[i] * (i - q.front()) >= k) {
                ans += i - q.front();
                q.pop_front();
            }
            q.push_back(i);
        }
        return ans;
    }
};