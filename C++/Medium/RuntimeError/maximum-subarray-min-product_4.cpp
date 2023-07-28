class Solution {
public:
    int maxSumMinProduct(vector<int>& nums) {
        
        int n = nums.size();
        vector<int> left(n), right(n);
        stack<int> st;
        for (int i = 0; i < n; ++i) {
            while (!st.empty() && nums[st.top()] >= nums[i]) {
                st.pop();
            }
            left[i] = st.empty() ? -1 : st.top();
            st.push(i);
        }
        while (!st.empty()) {
            st.pop();
        }
        for (int i = n - 1; i >= 0; --i) {
            while (!st.empty() && nums[st.top()] >= nums[i]) {
                st.pop();
            }
            right[i] = st.empty() ? n : st.top();
            st.push(i);
        }
        vector<int> sum(n + 1);
        for (int i = 0; i < n; ++i) {
            sum[i + 1] = sum[i] + nums[i];
        }
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            int l = left[i] + 1, r = right[i] - 1;
            int s = sum[r + 1] - sum[l];
            long long cur = 1LL * nums[i] * s;
            ans = max(ans, (int)(cur % 1000000007));
        }
        return ans;
    }
};