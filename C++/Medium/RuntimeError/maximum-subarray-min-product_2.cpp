class Solution {
public:
    int maxSumMinProduct(vector<int>& nums) {
        
        int n = nums.size();
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
        vector<int> sum(n + 1, 0);
        for (int i = 0; i < n; ++i) {
            sum[i + 1] = sum[i] + nums[i];
        }
        long ans = 0;
        for (int i = 0; i < n; ++i) {
            long cur = (long)(sum[right[i]] - sum[left[i] + 1]) * nums[i];
            ans = max(ans, cur);
        }
        return ans % 1000000007;
    }
};