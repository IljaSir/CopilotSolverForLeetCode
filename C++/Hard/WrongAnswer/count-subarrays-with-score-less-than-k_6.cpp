class Solution {
public:
    long long countSubarrays(vector<int>& nums, long long k) {
        
        long long res = 0;
        int n = nums.size();
        vector<long long> prefix(n+1, 0);
        for (int i = 1; i <= n; ++i) {
            prefix[i] = prefix[i-1] + nums[i-1];
        }
        deque<int> q;
        for (int i = 0; i <= n; ++i) {
            while (!q.empty() && prefix[i] <= prefix[q.back()]) {
                q.pop_back();
            }
            while (!q.empty() && prefix[i]*q.size() >= prefix[q.front()]*i) {
                q.pop_front();
            }
            q.push_back(i);
            res += q.size()-1;
        }
        return res;
    }
};