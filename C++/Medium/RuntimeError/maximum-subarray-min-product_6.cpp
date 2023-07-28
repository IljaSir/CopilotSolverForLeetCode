class Solution {
public:
    int maxSumMinProduct(vector<int>& nums) {
        
        int n = nums.size();
        vector<int> pre(n+1, 0);
        for (int i = 1; i <= n; ++i) {
            pre[i] = pre[i-1] + nums[i-1];
        }
        vector<int> left(n, -1), right(n, n);
        stack<int> s;
        for (int i = 0; i < n; ++i) {
            while (!s.empty() && nums[s.top()] >= nums[i]) {
                right[s.top()] = i;
                s.pop();
            }
            if (!s.empty()) {
                left[i] = s.top();
            }
            s.push(i);
        }
        long long res = 0, mod = 1e9 + 7;
        for (int i = 0; i < n; ++i) {
            res = max(res, (long long)nums[i] * (pre[right[i]] - pre[left[i]+1]));
        }
        return res % mod;
    }
};