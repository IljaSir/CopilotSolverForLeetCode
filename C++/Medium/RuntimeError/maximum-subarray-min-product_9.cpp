class Solution {
public:
    int maxSumMinProduct(vector<int>& nums) {
        
        const int mod = 1000000007;
        int n = nums.size();
        vector<int> sum(n + 1, 0);
        vector<int> left(n, -1);
        vector<int> right(n, n);
        stack<int> st;
        for (int i = 0; i < n; i++) {
            sum[i + 1] = sum[i] + nums[i];
            while (!st.empty() && nums[st.top()] >= nums[i]) {
                st.pop();
            }
            left[i] = st.empty() ? -1 : st.top();
            st.push(i);
        }
        while (!st.empty()) {
            st.pop();
        }
        for (int i = n - 1; i >= 0; i--) {
            while (!st.empty() && nums[st.top()] >= nums[i]) {
                st.pop();
            }
            right[i] = st.empty() ? n : st.top();
            st.push(i);
        }
        long long ans = 0;
        for (int i = 0; i < n; i++) {
            ans = max(ans, (long long)nums[i] * (sum[right[i]] - sum[left[i] + 1]));
        }
        return ans % mod;
    }
};