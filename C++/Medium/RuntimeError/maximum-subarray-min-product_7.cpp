class Solution {
public:
    int maxSumMinProduct(vector<int>& nums) {
        
        const int mod = 1e9 + 7;
        int n = nums.size();
        vector<int> sum(n + 1);
        for (int i = 0; i < n; ++i) {
            sum[i + 1] = sum[i] + nums[i];
        }
        vector<int> left(n);
        vector<int> right(n);
        stack<int> stk;
        for (int i = 0; i < n; ++i) {
            while (!stk.empty() && nums[stk.top()] >= nums[i]) {
                stk.pop();
            }
            left[i] = stk.empty() ? -1 : stk.top();
            stk.push(i);
        }
        while (!stk.empty()) {
            stk.pop();
        }
        for (int i = n - 1; i >= 0; --i) {
            while (!stk.empty() && nums[stk.top()] >= nums[i]) {
                stk.pop();
            }
            right[i] = stk.empty() ? n : stk.top();
            stk.push(i);
        }
        long long ans = 0;
        for (int i = 0; i < n; ++i) {
            ans = max(ans, (long long)(sum[right[i]] - sum[left[i] + 1]) * nums[i]);
        }
        return ans % mod;
    }
};