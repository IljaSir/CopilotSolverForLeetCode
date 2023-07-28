class Solution {
public:
    long long findScore(vector<int>& nums) {
        
        int n = nums.size();
        vector<int> left(n, -1);
        vector<int> right(n, n);
        stack<int> st;
        for (int i = 0; i < n; ++i) {
            while (!st.empty() && nums[st.top()] > nums[i]) {
                right[st.top()] = i;
                st.pop();
            }
            if (!st.empty()) {
                left[i] = st.top();
            }
            st.push(i);
        }
        long long ans = 0;
        for (int i = 0; i < n; ++i) {
            if (left[i] != -1 && right[i] != n) {
                ans += nums[i];
            }
        }
        return ans;
    }
};